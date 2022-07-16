package ir.filmnet.presentation.search.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.filmnet.databinding.RowSearchMovieBinding
import ir.filmnet.common.ui.GenericRecAdapter
import ir.filmnet.domain.model.Movie

class SearchMoviesRecAdapter : GenericRecAdapter<Movie>() {

    override fun getViewHolder(
        parent: ViewGroup,
        layoutInflater: LayoutInflater
    ): ViewHolder<Movie> {
        val binding = RowSearchMovieBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(
            binding,
            bind = { model, _ ->
                binding.movie = model
            }
        )
    }
}