package tw.mason.mcdonalds.screen.point

sealed class PointUiState {
    object Loading: PointUiState()
    class Success(val list: List<PointExchangeItem> = listOf()): PointUiState()
}