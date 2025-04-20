package com.codandotv.streamplayerapp.feature_news.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.codandotv.streamplayerapp.core_navigation.routes.BottomNavRoutes
import com.codandotv.streamplayerapp.core_navigation.routes.Routes.DETAIL_COMPLETE
import com.codandotv.streamplayerapp.feature_news.presentation.screens.NewsScreen

fun NavGraphBuilder.newsStreamNavGraph(navController: NavHostController) {
    composable(BottomNavRoutes.NEWS) { _ ->
        NewsScreen(
            navController = navController,
            onClickCamera = {

            },
            onClickGallery = {

            })
    }
}
