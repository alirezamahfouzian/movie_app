package ir.filmnet.common.ui

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

/**
 * this way of implementation of DiffUtil run in main thread
 * for implementation that run on the background thread see AsyncListDiffer
 */
class DiffUtilsListAdapter<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(
        oldItem: T,
        newItem: T
    ): Boolean {
        return oldItem == newItem
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: T,
        newItem: T
    ): Boolean {
        return oldItem == newItem
    }
}