package ir.filmnet.domain.repository

import ir.filmnet.domain.model.Movie

interface SearchRepository {

    fun searchMovies(query: String): List<Movie>
}