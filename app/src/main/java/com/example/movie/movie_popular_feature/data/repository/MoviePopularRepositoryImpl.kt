package com.example.movie.movie_popular_feature.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.movie.core.domain.model.Movie
import com.example.movie.movie_popular_feature.domain.repository.MoviePopularRepository
import com.example.movie.movie_popular_feature.domain.source.MoviePopularRemoteDataSource
import kotlinx.coroutines.flow.Flow

class MoviePopularRepositoryImpl constructor(
    private val remoteDataSource:MoviePopularRemoteDataSource
):MoviePopularRepository {
    override fun getPopularMovie(pagingConfig: PagingConfig): Flow<PagingData<Movie>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                remoteDataSource.getPopularMoviePagingSource()
            }
        ).flow
    }
}