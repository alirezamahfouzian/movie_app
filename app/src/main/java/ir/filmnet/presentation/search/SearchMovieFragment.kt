package ir.filmnet.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.filmnet.databinding.FragmentSearchMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import ir.filmnet.presentation.search.recyclerview.SearchMoviesRecAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@AndroidEntryPoint
class SearchMovieFragment : Fragment() {

    private var _binding: FragmentSearchMovieBinding? = null
    private val binding get() = _binding!!

    private val searchMovieViewModel: SearchMovieViewModel by activityViewModels()

    private val searchMoviesRecAdapter by lazy { SearchMoviesRecAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchMovieBinding.inflate(inflater, container, false)
        binding.viewModel = searchMovieViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
        getSearchResult()
    }

    private fun setRecyclerView() {
        binding.RecyclerViewSearch.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = searchMoviesRecAdapter
        }
    }

    private fun getSearchResult() {
        searchMovieViewModel.searchQueryResult.onEach {
            searchMoviesRecAdapter.submitList(it)
            binding.RecyclerViewSearch.scrollToPosition(0)
        }.launchIn(lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}