package search.presentation.navigation

import androidx.activity.compose.BackHandler
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.codandotv.streamplayerapp.core_navigation.routes.Routes
import search.di.SearchModule
import search.presentation.screens.SearchScreen
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

fun NavGraphBuilder.searchStreamsNavGraph(navController: NavHostController) {
    composable(Routes.SEARCH) { nav ->
        BackHandler(true) {}
        if (nav.lifecycle.currentState == Lifecycle.State.STARTED) {
            loadKoinModules(SearchModule.module)
        }
        SearchScreen(
            navController = navController,
            onNavigateDetailList = { id ->
                navController.navigate("${Routes.DETAIL}${id}")
            },
            disposable = {
                unloadKoinModules(SearchModule.module)
            }
        )
    }
}
