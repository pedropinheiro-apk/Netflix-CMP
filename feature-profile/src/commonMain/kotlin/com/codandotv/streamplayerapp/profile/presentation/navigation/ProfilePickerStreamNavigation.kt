package com.codandotv.streamplayerapp.profile.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.codandotv.streamplayerapp.core_navigation.routes.BottomNavRoutes.HOME
import com.codandotv.streamplayerapp.core_navigation.routes.BottomNavRoutes.PARAM.PROFILE_ID
import com.codandotv.streamplayerapp.core_navigation.routes.Routes
import com.codandotv.streamplayerapp.profile.di.ProfilePickerStreamModule
import com.codandotv.streamplayerapp.profile.presentation.screens.ProfilePickerStreamScreen
import org.koin.compose.module.rememberKoinModules
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
fun NavGraphBuilder.profilePickerStreamNavGraph(navController: NavHostController) {
    composable(Routes.PROFILE_PICKER) {
        rememberKoinModules {
            listOf(ProfilePickerStreamModule.module)
        }
        ProfilePickerStreamScreen(
            onNavigateListStreams = { profilePic ->
                navController.navigate("$HOME?$PROFILE_ID=$profilePic")
            }
        )
    }
}
