package com.example.filmnet.domain.repository

import com.example.filmnet.domain.model.Movie

interface SearchRepository {

    fun searchMovie(query: String): List<Movie>
}