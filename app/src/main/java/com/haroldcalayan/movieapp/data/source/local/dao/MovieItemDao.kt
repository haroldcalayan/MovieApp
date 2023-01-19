package com.haroldcalayan.movieapp.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.haroldcalayan.movieapp.common.base.BaseDao
import com.haroldcalayan.movieapp.data.source.local.entity.MovieItemEntity

@Dao
interface MovieItemDao : BaseDao<MovieItemEntity> {

    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun all(): List<MovieItemEntity>?

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
    suspend fun get(id: Int): MovieItemEntity?

    @Query("SELECT * FROM $TABLE_NAME ORDER BY id DESC LIMIT 1")
    suspend fun getFirst(): MovieItemEntity?

    @Query("UPDATE $TABLE_NAME SET isOnMyWatchList = :isOnWatchlist WHERE id = :id")
    suspend fun updateWatchlist(id: Int, isOnWatchlist: Boolean)

    @Query("DELETE FROM $TABLE_NAME")
    suspend fun nukeTable()

    companion object {
        const val TABLE_NAME = "movieItem"
    }
}