package com.sistemexico.schoolmanager.adapter

import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.sistemexico.schoolmanager.FullscreenImageActivity
import com.sistemexico.schoolmanager.bottomToBottomOf
import com.sistemexico.schoolmanager.databinding.WallPostBinding
import com.sistemexico.schoolmanager.endToEndOf
import com.sistemexico.schoolmanager.marginBottom

class WallPostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = WallPostBinding.bind(view)

    fun render(data: WallPostAdapter.Data) {
        binding.postProfilePicture.load(data.profilePicture)
        binding.profileUsername.text = data.profileUsername
        binding.time.text = data.time
        binding.textPost.text = data.text
        restore()
        pictures(data.listItems)
        listeners(data)
    }

    private fun restore() {
        binding.imageView.progressOne.bottomToBottomOf(binding.imageView.guidelineHorizontal)
        binding.imageView.progressTwo.bottomToBottomOf(binding.imageView.guidelineHorizontal)
        binding.imageView.imageOne.bottomToBottomOf(binding.imageView.guidelineHorizontal)
        binding.imageView.imageTwo.bottomToBottomOf(binding.imageView.guidelineHorizontal)
        binding.imageView.progressOne.marginBottom(
            binding.imageView.imageOne.parent as ConstraintLayout,
            3f
        )
        binding.imageView.progressTwo.marginBottom(
            binding.imageView.imageOne.parent as ConstraintLayout,
            3f
        )
        binding.imageView.imageOne.marginBottom(
            binding.imageView.imageOne.parent as ConstraintLayout,
            3f
        )
        binding.imageView.imageTwo.marginBottom(
            binding.imageView.imageOne.parent as ConstraintLayout,
            3f
        )
        binding.imageView.progressOne.endToEndOf(binding.imageView.guidelineVertical)
        binding.imageView.imageOne.endToEndOf(binding.imageView.guidelineVertical)

        binding.imageView.imageTwo.visibility = View.VISIBLE
        binding.imageView.progressTwo.visibility = View.VISIBLE
        binding.imageView.imageThree.visibility = View.VISIBLE
        binding.imageView.progressThree.visibility = View.VISIBLE
        binding.imageView.imageFour.visibility = View.VISIBLE
        binding.imageView.progressFour.visibility = View.VISIBLE
    }

    private fun listeners(data: WallPostAdapter.Data) {
        binding.imageView.imageOne.setOnClickListener {
            val intent =
                Intent(binding.cardViewProfile.context, FullscreenImageActivity::class.java).apply {
                    putExtra("image_url", data.listItems[0])
                }
            startActivity(binding.cardViewProfile.context, intent, null)
        }
        binding.imageView.imageTwo.setOnClickListener {
            val intent =
                Intent(binding.cardViewProfile.context, FullscreenImageActivity::class.java).apply {
                    putExtra("image_url", data.listItems[1])
                }
            startActivity(binding.cardViewProfile.context, intent, null)
        }
        binding.imageView.imageThree.setOnClickListener {
            val intent =
                Intent(binding.cardViewProfile.context, FullscreenImageActivity::class.java).apply {
                    putExtra("image_url", data.listItems[2])
                }
            startActivity(binding.cardViewProfile.context, intent, null)
        }
        binding.imageView.imageFour.setOnClickListener {
            val intent =
                Intent(binding.cardViewProfile.context, FullscreenImageActivity::class.java).apply {
                    putExtra("image_url", data.listItems[3])
                }
            startActivity(binding.cardViewProfile.context, intent, null)
        }
    }

    private fun pictures(dataList: List<String>) {
        when (dataList.size) {
            1 -> {
                binding.imageView.imageTwo.visibility = View.INVISIBLE
                binding.imageView.progressTwo.visibility = View.INVISIBLE
                binding.imageView.imageThree.visibility = View.INVISIBLE
                binding.imageView.progressThree.visibility = View.INVISIBLE
                binding.imageView.imageFour.visibility = View.INVISIBLE
                binding.imageView.progressFour.visibility = View.INVISIBLE
                binding.imageView.progressOne.bottomToBottomOf(binding.imageView.imageOne.parent as ConstraintLayout)
                binding.imageView.progressOne.marginBottom(
                    binding.imageView.imageOne.parent as ConstraintLayout,
                    0f
                )
                binding.imageView.progressOne.endToEndOf(binding.imageView.imageOne.parent as ConstraintLayout)
                binding.imageView.imageOne.bottomToBottomOf(binding.imageView.imageOne.parent as ConstraintLayout)
                binding.imageView.imageOne.marginBottom(
                    binding.imageView.imageOne.parent as ConstraintLayout,
                    0f
                )
                binding.imageView.imageOne.endToEndOf(binding.imageView.imageOne.parent as ConstraintLayout)
                loadPicture(binding.imageView.imageOne, binding.imageView.progressOne, dataList[0])
            }

            2 -> {
                binding.imageView.imageThree.visibility = View.INVISIBLE
                binding.imageView.progressThree.visibility = View.INVISIBLE
                binding.imageView.imageFour.visibility = View.INVISIBLE
                binding.imageView.progressFour.visibility = View.INVISIBLE
                binding.imageView.progressOne.bottomToBottomOf(binding.imageView.imageOne.parent as ConstraintLayout)
                binding.imageView.progressOne.marginBottom(
                    binding.imageView.imageOne.parent as ConstraintLayout,
                    0f
                )
                binding.imageView.progressTwo.bottomToBottomOf(binding.imageView.imageTwo.parent as ConstraintLayout)
                binding.imageView.progressTwo.marginBottom(
                    binding.imageView.imageTwo.parent as ConstraintLayout,
                    0f
                )
                binding.imageView.imageOne.bottomToBottomOf(binding.imageView.imageOne.parent as ConstraintLayout)
                binding.imageView.imageOne.marginBottom(
                    binding.imageView.imageOne.parent as ConstraintLayout,
                    0f
                )
                binding.imageView.imageTwo.bottomToBottomOf(binding.imageView.imageTwo.parent as ConstraintLayout)
                binding.imageView.imageTwo.marginBottom(
                    binding.imageView.imageTwo.parent as ConstraintLayout,
                    0f
                )

                loadPicture(binding.imageView.imageOne, binding.imageView.progressOne, dataList[0])
                loadPicture(binding.imageView.imageTwo, binding.imageView.progressTwo, dataList[1])
            }

            3 -> {
                binding.imageView.imageFour.visibility = View.INVISIBLE
                binding.imageView.progressFour.visibility = View.INVISIBLE
                binding.imageView.progressOne.bottomToBottomOf(binding.imageView.imageOne.parent as ConstraintLayout)
                binding.imageView.progressOne.marginBottom(
                    binding.imageView.imageOne.parent as ConstraintLayout,
                    0f
                )
                binding.imageView.imageOne.bottomToBottomOf(binding.imageView.imageOne.parent as ConstraintLayout)
                binding.imageView.imageOne.marginBottom(
                    binding.imageView.imageOne.parent as ConstraintLayout,
                    0f
                )
                loadPicture(binding.imageView.imageOne, binding.imageView.progressOne, dataList[0])
                loadPicture(binding.imageView.imageTwo, binding.imageView.progressTwo, dataList[1])
                loadPicture(
                    binding.imageView.imageThree,
                    binding.imageView.progressThree,
                    dataList[2]
                )
            }

            4 -> {
                loadPicture(binding.imageView.imageOne, binding.imageView.progressOne, dataList[0])
                loadPicture(binding.imageView.imageTwo, binding.imageView.progressTwo, dataList[1])
                loadPicture(
                    binding.imageView.imageThree,
                    binding.imageView.progressThree,
                    dataList[2]
                )
                loadPicture(
                    binding.imageView.imageFour,
                    binding.imageView.progressFour,
                    dataList[3]
                )
            }
        }
    }

    private fun loadPicture(image: ImageView, progress: ProgressBar, url: String) {
        Glide.with(image.context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .listener(object : RequestListener<Drawable?> {
                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: Target<Drawable?>?,
                    dataSource: com.bumptech.glide.load.DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    // Oculta la ProgressBar una vez que la imagen está lista
                    progress.visibility = View.GONE
                    return false
                }

                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable?>,
                    isFirstResource: Boolean
                ): Boolean {
                    // Oculta la ProgressBar si la carga de la imagen falla
                    progress.visibility = View.GONE
                    return false
                }
            })
            .into(image)
    }

}
