package com.example.newyorktimesapp.ui.mostpopular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newyorktimesapp.data.MostPopularRepository

class MostPopularVM(private val repo: MostPopularRepository) : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text

    fun fetchMostViewedArticles() {}

    fun fetchMostEmailedArticles() {}

    fun fetchMostSharedArticles() {}
}