package com.example.imdbapp.di

import com.example.imdbapp.data.repository.ImdbRepositoryImpl
import com.example.imdbapp.domain.repository.ImdbRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMyRepository(
        myRepositoryImpl: ImdbRepositoryImpl
    ): ImdbRepository
}
