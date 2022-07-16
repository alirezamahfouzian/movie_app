package ir.filmnet.data.remote.dto

import ir.filmnet.domain.model.Movie
import com.google.gson.annotations.SerializedName

data class VideoEntity(
    @SerializedName("age_restriction")
    val ageRestriction: String? = null,
    @SerializedName("alter_cover_image")
    val alterCoverImage: ImagePathDto? = null,
    val categories: List<CategoryDto?>? = null,
    @SerializedName("conditional_flag")
    val conditionalFlag: String? = null,
    @SerializedName("cover_image")
    val coverImage: ImagePathDto? = null,
    val duration: String? = null,
    val flag: String? = null,
    val id: String? = null,
    @SerializedName("imdb_rank_percent")
    val imdbRankPercent: Int? = null,
    @SerializedName("logo_image")
    val logoImage: ImagePathDto? = null,
    @SerializedName("original_name")
    val originalName: String? = null,
    @SerializedName("page_title")
    val pageTitle: String? = null,
    @SerializedName("poster_image")
    val posterImage: ImagePathDto? = null,
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


