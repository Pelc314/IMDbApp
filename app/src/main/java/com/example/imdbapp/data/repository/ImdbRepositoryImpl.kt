package com.example.imdbapp.data.repository

import com.example.imdbapp.core.util.Resource
import com.example.imdbapp.data.local.TopMoviesDatabase
import com.example.imdbapp.data.mapper.* // ktlint-disable no-wildcard-imports
import com.example.imdbapp.data.mapper.actormappers.toActor
import com.example.imdbapp.data.mapper.actormappers.toActorDetails
import com.example.imdbapp.data.mapper.actormappers.toActorResponse
import com.example.imdbapp.data.mapper.actormappers.toKnownFor
import com.example.imdbapp.data.mapper.moviemappers.toMovie
import com.example.imdbapp.data.mapper.moviemappers.toMovieResponse
import com.example.imdbapp.data.mapper.moviemappers.toTopMovie
import com.example.imdbapp.data.mapper.moviemappers.toTopMovieEntity
import com.example.imdbapp.data.mapper.searchresultsmappers.toSearchResults
import com.example.imdbapp.data.remote.IMDbApi
import com.example.imdbapp.domain.model.actor.Actor
import com.example.imdbapp.domain.model.actor.KnownFor
import com.example.imdbapp.domain.model.movie.Movie
import com.example.imdbapp.domain.model.movie.TopMovie
import com.example.imdbapp.domain.model.searchresults.SearchResults
import com.example.imdbapp.domain.repository.ImdbRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ImdbRepositoryImpl @Inject constructor(
    private val api: IMDbApi,
    private val db: TopMoviesDatabase,
) : ImdbRepository {

    private val dao = db.movieDatabaseDao

    override suspend fun getTopRatedMovies(): Flow<Resource<List<TopMovie>>> {
        return flow {
            emit(Resource.Loading())
            val localResponseTopMovies = dao.getTopMovies().map { it.toTopMovie() }
            if (!localResponseTopMovies.isEmpty()) {
                emit(Resource.Success(data = localResponseTopMovies))
                return@flow
            }
            try {
                var topMoviesRemote: List<TopMovie> = api.getTopRatedMovies().map { it.toTopMovie() }
                topMoviesRemote = topMoviesRemote.dropLast(240)
                repeat(topMoviesRemote.size) { i ->
                    val remoteResponseTopMovie =
                        api.findMovieorActor(topMoviesRemote[i].id ?: "null")
                            .toMovieResponse()
                            .results[0]
                    topMoviesRemote[i].imageUrl = remoteResponseTopMovie.image?.url
                    topMoviesRemote[i].title = remoteResponseTopMovie.title
                }
                emit(Resource.Success(topMoviesRemote))
                topMoviesRemote.let { topMovies ->
                    dao.clearTopMovies()
                    dao.insertTopMovies(topMovies.map { it.toTopMovieEntity() })
                }
            } catch (e: HttpException) {
                emit(
                    Resource.Error(

                        e.message ?: "Unexpected http Error, wrong return code from HTTP",

                    ),
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        e.message ?: "Unexpected IO exception, check your Internet connection 0_0",
                    ),
                )
            }
        }
    }

    override suspend fun getSearchResults(query: String): Flow<Resource<SearchResults>> {
        return flow {
            emit(Resource.Loading())
            try {
                val searchResults = api.findMovieorActor(query.lowercase())
                emit(Resource.Success(data = searchResults.toSearchResults()))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        e.message ?: "Unexpected http Error, wrong return code from HTTP",
                    ),
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        e.message ?: "Unexpected IO exception, check your Internet connection 0_0",
                    ),
                )
            }
        }
    }

    override suspend fun getMovieDetails(query: String): Flow<Resource<Movie>> {
        return flow {
            emit(Resource.Loading())
            try {
                val movie = api.findMovieorActor(query)
                    .toMovieResponse()
                    .results[0]
                val movieDetails = movie
                    .toSearchResultsDetails()
                    .toMovie()
                // REST API doesn't provide those two values in one endpoint
                val ratingAndDescription =
                    api.getOverviewDetails(movieDetails.id)
                movieDetails.chartRating = ratingAndDescription.ratings
                movieDetails.description = ratingAndDescription.plotOutline
                emit(Resource.Success(data = movieDetails))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        e.message ?: "Unexpected http Error, wrong return code from HTTP",
                    ),
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        e.message ?: "Unexpected IO exception, check your Internet connection 0_0",
                    ),
                )
            }
        }
    }

    override suspend fun getActor(query: String): Flow<Resource<Actor>> {
        return flow {
            emit(Resource.Loading())
            try {
                val actorResponse = api.findMovieorActor(query)
                    .toActorResponse()
                    .results[0]
                val actor = actorResponse.toSearchResultsDetails().toActor()
                emit(Resource.Success(data = actor))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        e.message ?: "Unexpected http Error, wrong return code from HTTP",
                    ),
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        e.message ?: "Unexpected IO exception, check your Internet connection 0_0",
                    ),
                )
            }
        }
    }

    override suspend fun getActorDetails(query: String): Flow<Resource<Actor>> {
        return flow {
            emit(Resource.Loading())
            try {
                val actor = api.getActorDetails(query).toActorDetails()
                emit(Resource.Success(data = actor))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        e.message ?: "Unexpected http Error, wrong return code from HTTP",
                    ),
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        e.message ?: "Unexpected IO exception, check your Internet connection 0_0",
                    ),
                )
            }
        }
    }

    override suspend fun getKnownFor(query: String): Flow<Resource<List<KnownFor>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val knownForList = api.getKnownFor(query).map { it.toKnownFor() }
                emit(Resource.Success(data = knownForList))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        e.message ?: "Unexpected http Error, wrong return code from HTTP",
                    ),
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        e.message ?: "Unexpected IO exception, check your Internet connection 0_0",
                    ),
                )
            }
        }
    }
}
