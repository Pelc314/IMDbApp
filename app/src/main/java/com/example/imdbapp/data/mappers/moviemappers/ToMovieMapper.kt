package com.example.imdbapp.data.mappers.moviemappers // ktlint-disable filename

import com.example.imdbapp.domain.model.movie.Movie
import com.example.imdbapp.domain.model.searchresults.SearchResultsDetails

fun SearchResultsDetails.toMovie(): Movie {
    return Movie(
        episode = episode,
        id = id,
        image = image,
        nextEpisode = nextEpisode,
        previousEpisode = previousEpisode,
        principals = principals,
        runningTimeInMinutes = runningTimeInMinutes,
        season = season,
        seriesStartYear = seriesStartYear,
        title = title,
        titleType = titleType,
        year = year,
        chartRating = chartRating,
        description = description
    )
}
