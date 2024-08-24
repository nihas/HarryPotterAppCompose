package app.map.harrypotter.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import app.map.harrypotter.domain.usecases.characters.GetCharacters
import app.map.harrypotter.domain.usecases.characters.HarryPotterUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val harryPotterUseCases: HarryPotterUseCases
): ViewModel() {

    var state = mutableStateOf(HomeState())
        private set

    // Define a MutableStateFlow to hold the characters
//    private val _characters = MutableStateFlow(NewsUiState())
//    val characters: StateFlow<NewsUiState> get() = _characters


//    fun fetchAllMyProducts(){
//        viewModelScope.launch {
//            getAllMyProductUseCase.invoke()
//                .onStart {
//                    setLoading()
//                }
//                .catch { exception ->
//                    hideLoading()
//                    showToast(exception.message.toString())
//                }
//                .collect { result ->
//                    hideLoading()
//                    when(result){
//                        is BaseResult.Success -> {
//                            products.value = result.data
//                        }
//                        is BaseResult.Error -> {
//                            showToast(result.rawResponse.message)
//                        }
//                    }
//                }
//        }
//    }

    fun onEvent(event: HomeEvent){
        when(event){
            is HomeEvent.UpdateScrollValue -> updateScrollValue(event.newValue)
            is HomeEvent.UpdateMaxScrollingValue -> updateScrollValue(event.newValue)
        }
    }

    private fun updateScrollValue(newValue: Int){
//        state.value = state.value.copy(scrollValue = newValue)
    }
    private fun updateMaxScrollingValue(newValue: Int){
//        state.value = state.value.copy(maxScrollingValue = newValue)
    }
}