package com.example.imdbapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopMovies(
        topMovieEntity: List<TopMovieEntity>
    )

    @Query("DELETE FROM topmovieentity")
    suspend fun clearTopMovies()

    @Query("SELECT * FROM topmovieentity")
    suspend fun getTopMovies(): List<TopMovieEntity>
}
