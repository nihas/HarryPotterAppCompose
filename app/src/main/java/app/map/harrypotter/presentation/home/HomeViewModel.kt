package app.map.harrypotter.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

//@HiltViewModel
//class HomeViewModel: ViewModel() {

//    var state = mutableStateOf(HomeState())
//        private set

//    fun onEvent(event: HomeEvent){
//        when(event){
//            is HomeEvent.UpdateScrollValue -> updateScrollValue(event.newValue)
//            is HomeEvent.UpdateMaxScrollingValue -> updateScrollValue(event.newValue)
//        }
//    }
//
//    private fun updateScrollValue(newValue: Int){
//        state.value = state.value.copy(scrollValue = newValue)
//    }
//    private fun updateMaxScrollingValue(newValue: Int){
//        state.value = state.value.copy(maxScrollingValue = newValue)
//    }
//}