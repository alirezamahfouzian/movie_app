package ir.filmnet.data.repository

import ir.filmnet.domain.model.Movie
import ir.filmnet.domain.repository.SearchRepository

class SearchRepositoryImpl: SearchRepository {
    override fun searchMovies(query: String): List<Movie> {
        TODO("Not yet implemented")
    }
}