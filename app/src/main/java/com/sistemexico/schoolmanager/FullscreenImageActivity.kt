package com.sistemexico.schoolmanager

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.github.chrisbanes.photoview.PhotoView
import com.google.android.material.snackbar.Snackbar
import com.sistemexico.schoolmanager.databinding.ActivityFullscreenImageBinding
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class FullscreenImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullscreenImageBinding
    private lateinit var photoView: PhotoView
    private var enable: Boolean = false
    private var isTopBarVisible = true
    private lateinit var progressBar: ProgressBar
    private var isToggleButton = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullscreenImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageUrl = intent.getStringExtra("image_url")
        initUI(imageUrl)
    }

    private fun initUI(imageUrl: String?) {
        loaders(imageUrl)
        clickListeners(imageUrl)
    }

    private fun loaders(imageUrl: String?) {
        binding.shareButton.isEnabled = false
        binding.downloadButton.isEnabled = false
        photoView = binding.photoView
        progressBar = binding.progressBar
        Glide.with(this)
            .load(imageUrl)
            .listener(object : RequestListener<Drawable> {

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    // Ocultar la rueda de carga si la carga falla
                    progressBar.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: Target<Drawable>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    photoView.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                    binding.shareButton.isEnabled = true
                    binding.downloadButton.isEnabled = true
                    return false
                }
            })
            .into(photoView)

        val menuIc = binding.topBar.menu.findViewById<ImageView>(R.id.menuIc)
        menuIc.setImageResource(R.drawable.ic_back)
    }

    private fun clickListeners(imageUrl: String?) {
        //Activar o desactivar adornos de imagen
        val topBar = binding.topBar.root
        val toggleButton = binding.toggleButton
        photoView = binding.photoView
        photoView.setOnClickListener {
            enable = !enable
            isTopBarVisible = toggleVisibility(topBar, isTopBarVisible)
            isToggleButton = toggleVisibility(toggleButton, isToggleButton)
            toggleFullScreen(enable)
        }
        //Salir de actividad
        binding.topBar.menu.setOnClickListener {
            finish()
        }
        //Listener para share y download
        binding.toggleButton.addOnButtonCheckedListener { group, checkedId, isChecked ->
            when (checkedId) {
                R.id.shareButton -> {
                    // Realizar acciones para el botón de compartir
                    if (isChecked) {
                        shareImageFromPhotoView()
                        group.clearChecked()
                    }
                }

                R.id.downloadButton -> {
                    // Realizar acciones para el botón de descarga
                    if (isChecked) {
                        downloadImageFromPhotoView(imageUrl!!)
                        group.clearChecked()
                    }
                }
            }
        }
    }

    private fun shareImageFromPhotoView() {
        val drawable = photoView.drawable
        val bmpDrawable = drawable as BitmapDrawable
        val bitmap = bmpDrawable.bitmap

        try {
            val cachePath = File(cacheDir, "images")
            cachePath.mkdirs() // asegura que el directorio exista
            val stream = FileOutputStream("$cachePath/shared.png")
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            stream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val imagePath = File(cacheDir, "images")
        val newFile = File(imagePath, "shared.png")
        val contentUri = FileProvider.getUriForFile(this, "$packageName.fileprovider", newFile)

        if (contentUri != null) {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            shareIntent.setDataAndType(contentUri, contentResolver.getType(contentUri))
            shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri)
            //shareIntent.putExtra(Intent.EXTRA_TEXT, "This image is shared by android")
            startActivity(Intent.createChooser(shareIntent, "Elige un aplicación."))
        }
    }

    private fun downloadImageFromPhotoView(imageUrl: String) {
        val drawable = photoView.drawable
        val bmpDrawable = drawable as BitmapDrawable
        val bitmap = bmpDrawable.bitmap

        try {
            val downloadsDir =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val schoolManagerDir = File(downloadsDir, "School Manager")
            schoolManagerDir.mkdirs() // Asegura que el directorio exista

            val fileName = getImageFileNameFromUrl(imageUrl)
            val file = File(schoolManagerDir, fileName)
            val stream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            stream.close()

            // Notificar a la galería sobre la nueva imagen
            MediaScannerConnection.scanFile(this, arrayOf(file.absolutePath), null, null)
            val contextView = binding.root
            Snackbar.make(contextView, "Imagen guardada en Descargas", Snackbar.LENGTH_SHORT)
                .setAnchorView(binding.toggleButton)
                .setAction("Abrir") {
                    openImageInExternalApp(file)
                }
                .show()
        } catch (e: IOException) {
            e.printStackTrace()
            val contextView = binding.root
            Snackbar.make(
                contextView,
                "Error al guardar la imagen, vuelva a intentarlo",
                Snackbar.LENGTH_SHORT
            )
                .setAnchorView(binding.toggleButton)
                .show()
        }
    }

    private fun getImageFileNameFromUrl(imageUrl: String): String {
        // Obtener el nombre del archivo de la URL
        val uri = Uri.parse(imageUrl)
        return uri.lastPathSegment ?: "image.png"
    }

    private fun openImageInExternalApp(imageFile: File) {
        val contentUri = FileProvider.getUriForFile(this, "$packageName.fileprovider", imageFile)
        val viewIntent = Intent(Intent.ACTION_VIEW)
        viewIntent.setDataAndType(contentUri, "image/*")
        viewIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(Intent.createChooser(viewIntent, "Abrir imagen con"))
    }

    private fun toggleVisibility(topBar: View, currentVisibility: Boolean): Boolean {
        val animationDuration = 200L
        var isVisible = currentVisibility
        val fadeIn = AlphaAnimation(0f, 1f).apply {
            duration = animationDuration
        }
        val fadeOut = AlphaAnimation(1f, 0f).apply {
            duration = animationDuration
        }

        if (isVisible) {
            topBar.startAnimation(fadeOut)
            topBar.visibility = View.GONE
        } else {
            topBar.startAnimation(fadeIn)
            topBar.visibility = View.VISIBLE
        }
        return !isVisible // Devuelve el valor opuesto de visibilidad
    }

    private fun toggleFullScreen(enable: Boolean) {
        if (enable) {
            val ventana = window
            val parametros = ventana.attributes as WindowManager.LayoutParams
            parametros.layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
            ventana.attributes = parametros

            WindowCompat.setDecorFitsSystemWindows(window, false)
            WindowInsetsControllerCompat(window, binding.root).let { controller ->
                controller.hide(WindowInsetsCompat.Type.systemBars())
                controller.systemBarsBehavior =
                    WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            WindowCompat.setDecorFitsSystemWindows(window, true)
            WindowInsetsControllerCompat(
                window,
                binding.root
            ).show(WindowInsetsCompat.Type.systemBars())
        }
    }

}