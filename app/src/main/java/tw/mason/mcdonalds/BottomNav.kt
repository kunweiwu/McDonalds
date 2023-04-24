package tw.mason.mcdonalds

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import tw.mason.mcdonalds.screen.AccountScreen
import tw.mason.mcdonalds.screen.home.HomeScreen
import tw.mason.mcdonalds.screen.PayScreen
import tw.mason.mcdonalds.screen.TaskScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav() {
    val navController = rememberNavController()

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination
    val navHelper = NavigationHelper(
        navController = navController,
        currentDestination = currentDestination
    )

    Scaffold(
        bottomBar = {
            BottomBar(navHelper = navHelper)
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomBarScreen.Home.route,
            modifier = Modifier.padding(it)
        ) {
            composable(route = BottomBarScreen.Home.route) {
                HomeScreen()
            }
            composable(route = BottomBarScreen.Task.route) {
                TaskScreen()
            }

            composable(route = BottomBarScreen.Point.route) {
                PayScreen()
            }
            composable(route = BottomBarScreen.Account.route) {
                AccountScreen()
            }
        }
    }
}

