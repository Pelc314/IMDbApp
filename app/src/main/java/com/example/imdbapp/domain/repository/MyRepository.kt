package com.example.imdbapp.domain.repository

interface MyRepository {
    suspend fun callMostPopularCelebs()
}
