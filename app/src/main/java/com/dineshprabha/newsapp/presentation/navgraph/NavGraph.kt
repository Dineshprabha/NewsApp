package com.dineshprabha.newsapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.dineshprabha.newsapp.presentation.news_navigator.NewsNavigator
import com.dineshprabha.newsapp.presentation.onboarding.OnBoardingScreen
import com.dineshprabha.newsapp.presentation.onboarding.OnBoardingViewModel
import com.dineshprabha.newsapp.presentation.search.SearchScreen
import com.dineshprabha.newsapp.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = startDestination){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(
                route = Route.OnBoardingScreen.route
            ){
                val viewModel : OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ){
            composable(route = Route.NewsNavigatorScreen.route){
                val viewModel : SearchViewModel = hiltViewModel()
                NewsNavigator()
            }
        }
    }

}