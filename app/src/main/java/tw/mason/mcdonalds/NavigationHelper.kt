package tw.mason.mcdonalds

import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptionsBuilder

class NavigationHelper constructor(
    private val navController: NavController,
    private val currentDestination: NavDestination?
) {

    private val builder: NavOptionsBuilder.() -> Unit = {
        popUpTo(navController.graph.findStartDestination().id)
        launchSingleTop = true
    }

    fun toScreen(screen: BottomBarScreen) {
        navController.navigate(
            route = screen.route,
            builder = builder
        )
    }

    fun isSelected(screen: BottomBarScreen): Boolean {
        if (currentDestination == null) return false
        return currentDestination.hierarchy.any { it.route == screen.route }
    }

}