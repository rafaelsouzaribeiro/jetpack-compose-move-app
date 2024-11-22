package com.example.movie.core.domain.model

import com.example.movie.core.data.remote.model.Genre

data class movieDetails(
    val id: Int,
    val title: String,
    val genres: List<Genre>,
    val overview: String?,
    val backdropPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    val duration: Int=0,
    val voteCount: Int=0
)
