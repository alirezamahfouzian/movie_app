package ir.filmnet.common.network

import ir.filmnet.common.constants.ApiConstants
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultHeaderInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request =
            chain.request().newBuilder().addHeader(
                ApiConstants.API_HEADER_PLATFORM,
                ApiConstants.API_HEADER_PLATFORM_VALUE
            ).build()
        return chain.proceed(request)
    }
}