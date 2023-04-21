package tw.mason.mcdonalds

sealed class BottomBarScreen(
    val route: String
) {
    object Home: BottomBarScreen("home")
    object Task: BottomBarScreen("task")
    object Point: BottomBarScreen("point")
    object Account: BottomBarScreen("account")

}