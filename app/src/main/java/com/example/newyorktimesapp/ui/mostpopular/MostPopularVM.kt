package com.example.newyorktimesapp.ui.mostpopular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newyorktimesapp.data.mostpopular.MostPopularRepository
import com.example.newyorktimesapp.entities.mostpopular.MostPopularType
import com.example.newyorktimesapp.entities.mostpopular.TimePeriod
import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI
import com.example.newyorktimesapp.ui.base.BaseVM
import kotlinx.coroutines.launch

class MostPopularVM(private val repo: MostPopularRepository) : BaseVM() {

    private val _articlesLD = MutableLiveData<List<ArticleUI>>()
    private val _favoriteIds = MutableLiveData<HashSet<Long>>()
    private val _errorLD = MutableLiveData<String>()

    val articlesLD: LiveData<List<ArticleUI>> = _articlesLD
    val favoriteIdsLD: LiveData<HashSet<Long>> = _favoriteIds
    val errorLD: LiveData<String> = _errorLD

    var type: MostPopularType? = null
        set(value) {
            if (field != value) {
                field = value
                fetchArticles()
            }
        }

    var timePeriod: TimePeriod? = null
        set(value) {
            if (field != value) {
                field = value
                fetchArticles()
            }
        }

    fun favoriteAction(favoriteState: Boolean, model: ArticleUI) {
        viewModelScope.launch {
            repo.updateFavoriteState(favoriteState, model)
            _favoriteIds.value = repo.fetchFavoriteIds()
        }
    }

    fun fetchFavoriteIds() {
        viewModelScope.launch {
            _favoriteIds.value = repo.fetchFavoriteIds()
        }
    }

    private fun fetchArticles() {
        changeLoadingState(true)
        viewModelScope.launch {
            try {
                val response = repo.fetchArticles(getType(), getTimePeriod())
                _articlesLD.value = response
                changeLoadingState(false)
            } catch (e: Exception) {
                _errorLD.value = e.message
                changeLoadingState(false)
            }
        }
    }

    private fun getType(): String = type?.popularType ?: MostPopularType.EMAILED.popularType

    private fun getTimePeriod(): Int = timePeriod?.timePeriod ?: TimePeriod.ONE_DAY.timePeriod
}