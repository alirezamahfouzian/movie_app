package ir.filmnet.common.network

import ir.filmnet.common.network.error_msg.NetworkGeneralError.GENERAL_ERROR_MSG
import retrofit2.Response

sealed class ApiResponse<T> {

    companion object {
        fun <T> create(error: Throwable): Error<T> {
            return Error(
                errorMessage = error.message ?: GENERAL_ERROR_MSG
            )
        }

        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if (response.isSuccessful) {
                Success(data = response.body())
            } else {
                Error(
                    errorMessage = GENERAL_ERROR_MSG
                )
            }
        }
    }

    class Loading<T> : ApiResponse<T>()
    data class Success<T>(val data: T?) : ApiResponse<T>()
    data class Error<T>(val errorMessage: String) : ApiResponse<T>()
}
