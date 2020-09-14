package com.example.newyorktimesapp.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.newyorktimesapp.R
import com.example.newyorktimesapp.ui.common.ArticleClickPayload
import com.example.newyorktimesapp.ui.common.BaseArticleFragment
import kotlinx.android.synthetic.main.frg_favorites.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoritesFragment : BaseArticleFragment() {

    private val favoritesVM: FavoritesVM by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.frg_favorites, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcv_favorites.adapter = articlesAdapter

        favoritesVM.articlesLD.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                rcv_favorites.isVisible = false
                tv_no_favorite.isVisible = true
            } else {
                rcv_favorites.isVisible = true
                tv_no_favorite.isVisible = false
                articlesAdapter.setArticleItems(it)
            }
        }

        favoritesVM.favoriteIdsLD.observe(viewLifecycleOwner) {
            articlesAdapter.setFavoriteItems(it)
        }
    }

    override fun favoriteAction(data: ArticleClickPayload.FavoriteAction) {
        favoritesVM.favoriteAction(data.favoriteState, data.model)
    }
}