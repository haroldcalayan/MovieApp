package com.haroldcalayan.movieapp.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.haroldcalayan.movieapp.data.source.local.dao.MovieItemDao
import com.haroldcalayan.movieapp.data.source.local.entity.MovieItemEntity

private const val VERSION_NUMBER = 1

@Database(
    entities = [MovieItemEntity::class],
    version = VERSION_NUMBER
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun movieItemDao(): MovieItemDao
}