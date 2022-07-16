package ir.filmnet.data.remote.api

import ir.filmnet.common.constants.search.SearchApiConstants.SEARCH_API_ENDPOINT
import ir.filmnet.common.constants.search.SearchApiConstants.SEARCH_API_PARAM_QUERY
import ir.filmnet.data.remote.dto.VideoDataDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchMoviesApi {

    @GET(SEARCH_API_ENDPOINT)
    suspend fun searchMovies(
        @Query(SEARCH_API_PARAM_QUERY) query: String
    ): Response<VideoDataDto>
}