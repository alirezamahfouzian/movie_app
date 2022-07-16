package ir.filmnet.common.network

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
}