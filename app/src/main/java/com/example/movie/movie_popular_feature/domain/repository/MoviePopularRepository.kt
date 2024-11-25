package com.example.movie.movie_popular_feature.domain.repository

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.movie.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MoviePopularRepository {

    fun getPopularMovie(pagingConfig:PagingConfig):Flow<PagingData<Movie>>
}