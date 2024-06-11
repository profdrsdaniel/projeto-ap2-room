package br.com.ulbra.exemplorecycler.commons.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import br.com.ulbra.exemplorecycler.R
import com.bumptech.glide.Glide

object BindingAdapter {
    @BindingAdapter("loadImg")
    @JvmStatic
    fun ImageView.loadImg(url: String) {
        Glide
            .with(context)
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(this)
    }
}