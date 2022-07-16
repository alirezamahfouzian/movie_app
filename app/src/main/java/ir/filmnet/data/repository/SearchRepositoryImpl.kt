package ir.filmnet.data.repository

import ir.filmnet.common.network.ApiResponse
import ir.filmnet.common.network.ResponseHandler.safeApiCall
import ir.filmnet.data.remote.api.SearchMoviesApi
import ir.filmnet.data.remote.dto.MovieDataDto
import ir.filmnet.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val searchMoviesApi: SearchMoviesApi) :
    SearchRepository {

    override suspend fun searchMovies(query: String): ApiResponse<MovieDataDto> = safeApiCall {
        searchMoviesApi.searchMovies(query)
    }
}