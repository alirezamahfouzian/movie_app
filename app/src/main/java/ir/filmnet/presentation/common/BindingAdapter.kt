package ir.filmnet.presentation.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

object BindingAdapter {

    @BindingAdapter("loadImageFromUrl")
    @JvmStatic
    fun loadImageFromUrl(imageView: ImageView, imageUrl: String?) {
        imageView.load(imageUrl)
    }
}