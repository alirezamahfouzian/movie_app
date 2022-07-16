package com.example.filmnet.data.remote.entity

import com.example.filmnet.domain.model.Movie
import com.google.gson.annotations.SerializedName

data class VideoEntity(
    @SerializedName("age_restriction")
    val ageRestriction: String? = null,
    @SerializedName("alter_cover_image")
    val alterCoverImage: ImagePath? = null,
    val categories: List<CategoryEntity?>? = null,
    @SerializedName("conditional_flag")
    val conditionalFlag: String? = null,
    @SerializedName("cover_image")
    val coverImage: ImagePath? = null,
    val duration: String? = null,
    val flag: String? = null,
    val id: String? = null,
    @SerializedName("imdb_rank_percent")
    val imdbRankPercent: Int? = null,
    @SerializedName("logo_image")
    val logoImage: ImagePath? = null,
    @SerializedName("original_name")
    val originalName: String? = null,
    @SerializedName("page_title")
    val pageTitle: String? = null,
    @SerializedName("poster_image")
    val posterImage: ImagePath? = null,
    val rate: Double? = null,
    @SerializedName("short_id")
    val shortId: String? = null,
    val slug: String? = null,
    val status: String? = null,
    val summary: String? = null,
    val title: String? = null,
    val type: String? = null,
    val year: Int? = null
)

fun VideoEntity.toMovie(): Movie {
    return Movie(
        title = this.title,
        posterImagePath = this.posterImage?.path,
        year = this.year
    )
}


