package ir.filmnet.common.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class GenericRecAdapter<T> :
    ListAdapter<T, GenericRecAdapter.ViewHolder<T>>(DiffUtilsListAdapter<T>()) {

    private val _clickLiveData: MutableLiveData<T> = MutableLiveData()
    val clickLiveData: LiveData<T> get() = _clickLiveData

    class ViewHolder<T>(binding: ViewDataBinding, val bind: (item: T, position: Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.executePendingBindings()
        }
    }

    abstract fun getViewHolder(parent: ViewGroup, layoutInflater: LayoutInflater): ViewHolder<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        return getViewHolder(parent, layoutInflater)
    }

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) {
        val item = getItem(position)
        setOnClickListener(holder, item)
        holder.bind(item, position)
    }

    private fun setOnClickListener(holder: ViewHolder<T>, item: T) {
        holder.itemView.setOnClickListener {
            _clickLiveData.value = item
        }
    }
}

