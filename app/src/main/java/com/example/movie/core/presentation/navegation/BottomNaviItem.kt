package com.example.movie.core.presentation.navegation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNaviItem(val title: String, val icon: ImageVector, val route: String) {
    data object MoviePopular : BottomNaviItem(
        title = "Filmes Popular",
        icon = Icons.Default.Movie,
        route = "movie_popular_Screen"
    )

    data object MovieSearch : BottomNaviItem(
        title = "Pesquisar",
        icon = Icons.Default.Search,
        route = "movie_search_Screen"
    )

    data object MovieFavorite : BottomNaviItem(
        title = "Favoritos",
        icon = Icons.Default.Favorite,
        route = "movie_favorite_Screen"
    )
}