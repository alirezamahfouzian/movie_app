package ir.filmnet.presentation.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.filmnet.common.network.ApiResponse
import ir.filmnet.domain.model.Movie
import ir.filmnet.domain.use_case.SearchMoviesUseCase
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchMovieViewModel @Inject constructor(
    private val searchMoviesUseCase: SearchMoviesUseCase
) : ViewModel() {

    private val _searchQueryResult = MutableStateFlow<List<Movie?>?>(emptyList())
    val searchQueryResult: StateFlow<List<Movie?>?> = _searchQueryResult

    val searchQueryText = MutableStateFlow<String>("")

    init {
        getSearchQueryState()
    }

    private fun getSearchQueryState() {
        searchQueryText.onEach {
            searchMovies(it)
        }.launchIn(viewModelScope)
    }

    var searchJob: Job? = null
    private fun searchMovies(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch(IO) {
            searchMoviesUseCase(query).collect {
                if (it is ApiResponse.Success)
                    _searchQueryResult.value = it.data
            }
        }
    }
}