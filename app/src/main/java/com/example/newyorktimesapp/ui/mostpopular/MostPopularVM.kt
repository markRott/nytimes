package com.example.newyorktimesapp.ui.mostpopular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newyorktimesapp.data.MostPopularRepository
import com.example.newyorktimesapp.entities.mostpopular.MostPopularType
import com.example.newyorktimesapp.entities.mostpopular.TimePeriod
import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularUI
import kotlinx.coroutines.launch

class MostPopularVM(private val repo: MostPopularRepository) : ViewModel() {

    private val _data = MutableLiveData<MostPopularUI>()
    private val _loadingState = MutableLiveData<Boolean>()

    val data: LiveData<MostPopularUI> = _data
    val loadingState: LiveData<Boolean> = _loadingState

    var type: MostPopularType? = null
        set(value) {
            if (field != value) {
                field = value
                fetchMostPopularArticles()
            }
        }

    var timePeriod: TimePeriod? = null
        set(value) {
            if (field != value) {
                field = value
                fetchMostPopularArticles()
            }
        }

    private fun fetchMostPopularArticles() {
        changeLoadingState(true)
        viewModelScope.launch {
            val response = repo.fetchMostPopularArticles(getType(), getTimePeriod())
            _data.value = response
            changeLoadingState(false)
        }
    }

    private fun changeLoadingState(state: Boolean) {
        _loadingState.value = state
    }

    private fun getType(): String = type?.popularType ?: MostPopularType.EMAILED.popularType

    private fun getTimePeriod(): Int = timePeriod?.timePeriod ?: TimePeriod.ONE_DAY.timePeriod
}