package com.example.movie.core.presentation.navegation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movie.ui.theme.Black
import com.example.movie.ui.theme.Yellow


@Composable
fun BottomNavigationBar(navController: NavController) {
    val items= listOf(
        BottomNaviItem.MoviePopular,
        BottomNaviItem.MovieSearch,
        BottomNaviItem.MovieFavorite
    )


    NavigationBar(containerColor = Black, contentColor =Yellow ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach {destination->
            NavigationBarItem(
                selected =currentRoute==destination.route,
                onClick ={
                    navController.navigate(destination.route){
                        launchSingleTop=true
                    }
                },
                icon={
                   Icon( imageVector = destination.icon,
                       contentDescription = destination.title,
                   )
                },
                label = {
                    Text(text = destination.title)
                }
            )

        }
    }
}

