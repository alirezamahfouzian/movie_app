package ir.filmnet.presentation.common

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

object BindingAdapter {

    @BindingAdapter("loadImageFromUrl")
    @JvmStatic
    fun loadImageFromUrl(imageView: ImageView, imageUrl: String?) {
        imageView.load(imageUrl)
    }

    @BindingAdapter("shouldShowOnLoading")
    @JvmStatic
    fun shouldShowOnLoading(view: View, isLoading: Boolean) {
        if (isLoading) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    @BindingAdapter("shouldHideOnLoading")
    @JvmStatic
    fun shouldHideOnLoading(view: View, isLoading: Boolean) {
        if (isLoading) {
            view.visibility = View.INVISIBLE
        } else {
            view.visibility = View.VISIBLE
        }
    }
}