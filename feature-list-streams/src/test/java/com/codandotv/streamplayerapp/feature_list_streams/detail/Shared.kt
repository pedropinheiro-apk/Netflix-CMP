package com.codandotv.streamplayerapp.feature_list_streams.detail

import detail.data.model.DetailStreamResponse
import detail.domain.DetailStream
import detail.domain.VideoStream

val videoStream = detail.domain.VideoStream(
    movieId = 123,
    videoId = "123"
)

const val MOVIE_ID_STRING = "123"

val videoStream1 = detail.domain.VideoStream(
    movieId = 1234565,
    videoId = "123565"
)

val videosStreamsList = listOf(
    videoStream,
    videoStream1
)

val detailStreamResponse = detail.data.model.DetailStreamResponse(
    id = "id",
    title = "title",
    overview = "overview",
    tagline = "tagline",
    backdrop_path = "backdrop",
    release_date = "release"
)

val detailStream = detail.domain.DetailStream(
    id = "id",
    title = "title",
    overview = "overview",
    tagline = "tagline",
    isFavorite = false,
    releaseYear = "backdrop",
    url = "palmeiras"
)