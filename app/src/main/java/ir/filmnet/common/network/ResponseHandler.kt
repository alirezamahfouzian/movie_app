package ir.filmnet.common.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object ResponseHandler {

    suspend inline fun <T> safeApiCall(
        crossinline requestFunction: suspend () -> Response<T>
    ): ApiResponse<T> {
        return try {
            val response = requestFunction()
            ApiResponse.create(response)
        } catch (e: Exception) {
            ApiResponse.create(e)
        }
    }

    fun <T, U> genericFlowResponse(
        response: ApiResponse<T>,
        successFunction: (T?) -> U?
    ): Flow<ApiResponse<U>> = flow {
        emit(ApiResponse.Loading())
        when (response) {
            is ApiResponse.Error -> {
                emit(ApiResponse.Error(response.errorMessage))
            }
            is ApiResponse.Success -> {
                emit(ApiResponse.Success(successFunction(response.data)))
            }
        }
    }
}