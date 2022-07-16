package ir.filmnet.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.filmnet.data.remote.api.SearchMoviesApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchMoviesNetworkModule {
    @Provides
    @Singleton
    fun provideSearchMoviesApi(
        retrofit: Retrofit
    ): SearchMoviesApi {
        return retrofit.create(SearchMoviesApi::class.java)
    }
}