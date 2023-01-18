package com.haroldcalayan.movieapp.data.source.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "movieItem", indices = [Index(value = ["title"], unique = true)])
data class MovieItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val title: String? = null,
    val imageId: Int? = null,
    val description: String? = null,
    val rating: Double? = null,
    val duration: String? = null,
    val genre: String? = null,
    val releaseDate: String? = null,
    val trailerLink: String? = null,
    val isOnMyWatchList: Boolean? = null,
)
