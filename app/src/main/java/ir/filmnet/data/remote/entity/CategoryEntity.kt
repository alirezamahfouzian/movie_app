package ir.filmnet.data.remote.entity

import android.content.ClipData

data class CategoryEntity(
    val items: List<ClipData.Item?>? = null,
    val type: String? = null
)