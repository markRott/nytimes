package com.example.newyorktimesapp.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseVM : ViewModel() {

    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> = _loadingState

    protected fun changeLoadingState(state: Boolean) {
        _loadingState.value = state
    }
}