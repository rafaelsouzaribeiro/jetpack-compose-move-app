package com.example.movie.movie_popular_feature.data.source

import com.example.movie.core.data.remote.MovieService
import com.example.movie.core.data.remote.response.MovieResponse
import com.example.movie.core.paging.MoviePagingSource
import com.example.movie.movie_popular_feature.domain.source.MoviePopularRemoteDataSource
import javax.inject.Inject

class MoviePopularRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
):MoviePopularRemoteDataSource {
    override fun getPopularMoviePagingSource(): MoviePagingSource {
        return MoviePagingSource(this)
    }

    override suspend fun getPopularMovie(page: Int): MovieResponse {
        return service.getPopularMovies(page=page)
    }

}