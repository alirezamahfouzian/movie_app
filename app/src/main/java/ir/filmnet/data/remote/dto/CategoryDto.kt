package ir.filmnet.data.remote.dto

import android.content.ClipData

data class CategoryDto(
    val items: List<ClipData.Item?>? = null,
    val type: String? = null
)