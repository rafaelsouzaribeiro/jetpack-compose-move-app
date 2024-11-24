package com.example.movie.core.presentation.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNaviItem.MoviePopular.route
    ){
        composable(route=BottomNaviItem.MoviePopular.route){

        }

        composable(route=BottomNaviItem.MovieSearch.route){

        }

        composable(route=BottomNaviItem.MovieFavorite.route){

        }
    }
    
}