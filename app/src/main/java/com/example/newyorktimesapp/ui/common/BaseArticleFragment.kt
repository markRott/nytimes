package com.example.newyorktimesapp.ui.common

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.newyorktimesapp.KEY_URL
import com.example.newyorktimesapp.R

abstract class BaseArticleFragment: Fragment() {

    protected val articlesAdapter: ArticleAdapter = ArticleAdapter { data ->
        when (data) {
            is ArticleClickPayload.ArticleAction -> Unit
            is ArticleClickPayload.CommentsAction -> { openCommentsFragment(data) }
            is ArticleClickPayload.FavoriteAction -> { favoriteAction(data) }
        }
    }

    private fun openCommentsFragment(data: ArticleClickPayload.CommentsAction) {
        val bundle = bundleOf(KEY_URL to data.model.url)
        findNavController().navigate(R.id.commentsFragment, bundle)
    }

    abstract fun favoriteAction(data: ArticleClickPayload.FavoriteAction)
}