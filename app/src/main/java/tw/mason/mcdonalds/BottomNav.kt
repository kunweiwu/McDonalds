package tw.mason.mcdonalds

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import tw.mason.mcdonalds.screen.AccountScreen
import tw.mason.mcdonalds.screen.home.HomeScreen
import tw.mason.mcdonalds.screen.PointScreen
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

    Box(modifier = Modifier) {
        NavHost(
            navController = navController,
            startDestination = BottomBarScreen.Home.route,
            modifier = Modifier.padding(bottom = BOTTOM_BAR_BASE_HEIGHT.dp)
        ) {
            composable(route = BottomBarScreen.Home.route) {
                HomeScreen()
            }
            composable(route = BottomBarScreen.Task.route) {
                TaskScreen()
            }

            composable(route = BottomBarScreen.Point.route) {
                PointScreen()
            }
            composable(route = BottomBarScreen.Account.route) {
                AccountScreen()
            }
        }
        BottomBar(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            navHelper = navHelper
        )
    }
}

