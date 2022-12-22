package com.example.simpleimdbapp.di

import com.example.simpleimdbapp.data.remote.IMDbApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideIMDbApi(): IMDbApi {
        return Retrofit.Builder()
            .baseUrl("https://imdb8.p.rapidapi.com/")
            .build()
            .create(IMDbApi::class.java)
    }

    @Provides
    @Singleton
    @Named("hello1")
    fun provideString1() = "Hello 1"

    @Provides
    @Singleton
    @Named("hello2")
    fun provideString2() = "Hello 2"
}
