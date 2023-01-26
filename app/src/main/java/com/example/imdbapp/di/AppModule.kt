package com.example.imdbapp.di

import com.example.imdbapp.core.Constants
import com.example.imdbapp.data.remote.IMDbApi
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

//    @Provides
//    @Singleton
//    fun provideIMDbRepository(api: IMDbApi): ImdbRepository {
//        return ImdbRepositoryImpl(api)
//    }
}
