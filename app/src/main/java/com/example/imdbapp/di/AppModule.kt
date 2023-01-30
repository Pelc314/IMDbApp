package com.example.imdbapp.di

import android.app.Application
import androidx.room.Room
import com.example.imdbapp.core.Constants
import com.example.imdbapp.data.local.TopMoviesDatabase
import com.example.imdbapp.data.remote.IMDbApi
import com.example.imdbapp.data.repository.ImdbRepositoryImpl
import com.example.imdbapp.domain.repository.ImdbRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideIMDbApi(): IMDbApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(IMDbApi::class.java)
    }

    @Provides
    @Singleton
    fun provideIMDbRepository(api: IMDbApi, db: TopMoviesDatabase): ImdbRepository {
        return ImdbRepositoryImpl(api, db)
    }

    @Provides
    @Singleton
    fun provideTopMoviesDatabase(app: Application): TopMoviesDatabase {
        return Room.databaseBuilder(
            app,
            TopMoviesDatabase::class.java,
            "topmovies.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}
