package com.example.newyorktimesapp.ui.mostpopular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newyorktimesapp.R
import com.example.newyorktimesapp.data.favorite.FavoriteRepository
import com.example.newyorktimesapp.data.mostpopular.MostPopularRepository
import com.example.newyorktimesapp.entities.mostpopular.MostPopularType
import com.example.newyorktimesapp.entities.mostpopular.TimePeriod
import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI
import com.example.newyorktimesapp.ui.base.BaseVM
import com.example.newyorktimesapp.utils.ResourcesProvider
import kotlinx.coroutines.launch

class MostPopularVM(
    private val articleRepo: MostPopularRepository,
    private val favoriteRepo: FavoriteRepository,
    private val resourceProvider: ResourcesProvider
) : BaseVM() {

    private val _articlesLD = MutableLiveData<List<ArticleUI>>()
    private val _favoriteIdsLD = MutableLiveData<HashSet<Long>>()
    private val _errorLD = MutableLiveData<String>()
    private val _headerTextLD = MutableLiveData<String>()

    val articlesLD: LiveData<List<ArticleUI>> = _articlesLD
    val favoriteIdsLD: LiveData<HashSet<Long>> = _favoriteIdsLD
    val errorLD: LiveData<String> = _errorLD
    val headerLD: LiveData<String> = _headerTextLD

    var type: MostPopularType = MostPopularType.EMAILED
        set(value) {
            if (field != value) {
                field = value
                fetchArticles()
                prepareHeaderText()
            }
        }

    var timePeriod: TimePeriod = TimePeriod.ONE_DAY
        set(value) {
            if (field != value) {
                field = value
                fetchArticles()
                prepareHeaderText()
            }
        }

    init {
        prepareHeaderText()
        fetchFavoriteIds()
        fetchArticles()
    }

    fun favoriteAction(favoriteState: Boolean, model: ArticleUI) {
        viewModelScope.launch {
            favoriteRepo.updateFavoriteState(favoriteState, model)
            _favoriteIdsLD.value = favoriteRepo.fetchArticlesIds().toHashSet()
        }
    }

    private fun fetchFavoriteIds() {
        viewModelScope.launch {
            _favoriteIdsLD.value = favoriteRepo.fetchArticlesIds().toHashSet()
        }
    }

    private fun fetchArticles() {
        changeLoadingState(true)
        viewModelScope.launch {
            try {
                val response = articleRepo.fetchArticles(getType(), getTimePeriod())
                _articlesLD.value = response
                changeLoadingState(false)
            } catch (e: Exception) {
                _errorLD.value = e.message
                changeLoadingState(false)
            }
        }
    }

    private fun prepareHeaderText() {
        val text = resourceProvider.getString(
            R.string.most_popular_title,
            getType().capitalize(),
            getTimePeriod())
        _headerTextLD.value = text
    }

    private fun getType(): String = type.popularType

    private fun getTimePeriod(): Int = timePeriod.period
}