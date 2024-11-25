package com.example.movie.movie_popular_feature.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.movie.core.domain.model.Movie
import com.example.movie.movie_popular_feature.domain.repository.MoviePopularRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetPopularMoviesUseCase{
    operator fun invoke():Flow<PagingData<Movie>>
}

class GetPopularMoviesUseCaseImpl @Inject constructor(
    private val repository: MoviePopularRepository
):GetPopularMoviesUseCase{
    override fun invoke(): Flow<PagingData<Movie>> {
        return repository.getPopularMovie(
            pagingConfig = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20
            )
        )
    }

}