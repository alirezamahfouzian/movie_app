package ir.filmnet.presentation.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.filmnet.domain.model.Movie
import ir.filmnet.domain.use_case.SearchMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchMovieViewModel @Inject constructor(
    private val searchMoviesUseCase: SearchMoviesUseCase
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("man")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _searchQueryResult = MutableStateFlow<List<Movie>>(emptyList())
    val searchQueryResult: StateFlow<List<Movie>> = _searchQueryResult

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            searchMoviesUseCase(searchQuery.value).collect {
                Log.d("TAGTAGTAG", "getCoins: $it")
            }
        }
    }


}