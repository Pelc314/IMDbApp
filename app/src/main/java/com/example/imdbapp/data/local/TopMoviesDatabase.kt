package com.example.imdbapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TopMovieEntity::class], version = 1)
abstract class TopMoviesDatabase : RoomDatabase() {
    abstract val movieDatabaseDao: MovieDatabaseDao
}
