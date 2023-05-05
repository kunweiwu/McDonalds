package tw.mason.mcdonalds.screen.point

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import tw.mason.mcdonalds.data.PointRepository

class PointViewModel(
    private val repository: PointRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<PointUiState>(PointUiState.Success())
    val uiState = _uiState.asStateFlow()

    private fun syncList() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = PointUiState.Loading
            try {
                val result = repository.getList()
                _uiState.value = PointUiState.Success(result)
            } catch (e: Exception) {
                // todo
            }
        }
    }
}
