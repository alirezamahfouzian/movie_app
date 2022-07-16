package ir.filmnet.domain.use_case

import ir.filmnet.common.network.ApiResponse
import ir.filmnet.common.network.ResponseHandler.genericFlowResponse
import ir.filmnet.data.remote.dto.toMovie
import ir.filmnet.domain.model.Movie
import ir.filmnet.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(
    private val repository: SearchRepository
) {

    suspend operator fun invoke(query: String): Flow<ApiResponse<List<Movie?>>> =
        genericFlowResponse(repository.searchMovies(query)) { moviesDto ->
            moviesDto?.data?.videos?.map { it?.toMovie() }
        }
}