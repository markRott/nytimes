package com.example.newyorktimesapp.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newyorktimesapp.data.favorite.FavoriteRepository
import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI
import com.example.newyorktimesapp.utils.updateMutableLiveData
import com.example.newyorktimesapp.utils.removeItem
import kotlinx.coroutines.launch

class FavoritesVM(private val favoriteRepo: FavoriteRepository) : ViewModel() {

    private val _articlesLD = MutableLiveData<List<ArticleUI>>()
    private val _favoriteIdsLD = MutableLiveData<HashSet<Long>>()

    val articlesLD: LiveData<List<ArticleUI>> = _articlesLD
    val favoriteIdsLD: LiveData<HashSet<Long>> = _favoriteIdsLD

    init {
        fetchAllArticles()
    }

    fun favoriteAction(favoriteState: Boolean, model: ArticleUI) {
        viewModelScope.launch {
            favoriteRepo.updateFavoriteState(favoriteState, model)
            if (!favoriteState) {
                _articlesLD.removeItem(model)
                _favoriteIdsLD.value?.remove(model.id)
                _favoriteIdsLD.updateMutableLiveData()
            }
        }
    }

    private fun fetchAllArticles() {
        viewModelScope.launch {
            val resp = favoriteRepo.fetchFavoriteArticles()
            val ids = resp.map { it.id }.toHashSet()
            _articlesLD.value = resp
            _favoriteIdsLD.value = ids
        }
    }

}