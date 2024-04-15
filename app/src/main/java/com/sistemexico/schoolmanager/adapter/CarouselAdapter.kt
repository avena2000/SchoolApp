package com.sistemexico.schoolmanager.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.sistemexico.schoolmanager.R

class CarouselAdapter(private val images: List<String>, private val listener: RecyclerViewEvent) :
    RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        return CarouselViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.image_item, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        holder.bind(images[position])
    }

    interface RecyclerViewEvent {
        fun onItemClick(position: Int)
    }

    inner class CarouselViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        private val carouselImageView: AppCompatImageView =
            view.findViewById(R.id.carousel_image_view)
        private val progressBar: ProgressBar = view.findViewById(R.id.progressBar)
        fun bind(imageUrl: String) {
            // Cargar la imagen
            Glide.with(carouselImageView.context)
                .load(imageUrl)
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
                        progressBar.visibility = View.GONE
                        return false
                    }

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable?>,
                        isFirstResource: Boolean
                    ): Boolean {
                        // Oculta la ProgressBar si la carga de la imagen falla
                        progressBar.visibility = View.GONE
                        return false
                    }
                })
                .into(carouselImageView)
            /* carouselImageView.load(imageUrl){
                 transformations(RoundedCornersTransformation(8f))
             }*/
        }

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
}