package ir.filmnet.domain.repository

import ir.filmnet.common.network.ApiResponse
import ir.filmnet.data.remote.dto.VideoDataDto

interface SearchRepository {

    suspend fun searchMovies(query: String): ApiResponse<VideoDataDto>
}