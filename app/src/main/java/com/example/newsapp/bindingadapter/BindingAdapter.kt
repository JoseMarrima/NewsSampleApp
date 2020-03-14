package com.example.newsapp.bindingadapter

import android.widget.ImageView
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import androidx.databinding.BindingAdapter
import com.example.newsapp.R

object BindingAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            val imgUri = imgUrl.toUri()

            Glide.with(imgView.context)
                .load(imgUri)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .placeholder(R.drawable.test)
                .error(R.drawable.test)
                .into(imgView)
        }
    }
}