package com.example.newyorktimesapp.ui.common

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.newyorktimesapp.KEY_TITLE
import com.example.newyorktimesapp.KEY_URL
import com.example.newyorktimesapp.R

abstract class BaseArticleFragment : Fragment() {

    private val navOptions = NavOptions.Builder()
        // logic of the opening screen
        .setEnterAnim(R.anim.slide_in_right)
        .setPopExitAnim(R.anim.slide_out_right)
        // logic of closing the screen
        .setExitAnim(R.anim.fade_out)
        .setPopEnterAnim(R.anim.fade_in)
        .build()

    protected val articlesAdapter: ArticleAdapter = ArticleAdapter { data ->
        when (data) {
            is ArticleClickPayload.ArticleAction -> {openArticleDetailFragment(data)}
            is ArticleClickPayload.CommentsAction -> { openCommentsFragment(data) }
            is ArticleClickPayload.FavoriteAction -> { favoriteAction(data) }
        }
    }

    private fun openCommentsFragment(data: ArticleClickPayload.CommentsAction) {
        val bundle = bundleOf(KEY_URL to data.model.url)
        findNavController().navigate(R.id.commentsFragment, bundle, navOptions)
    }

    private fun openArticleDetailFragment(data: ArticleClickPayload.ArticleAction) {
        val bundle = bundleOf(KEY_URL to data.model.url, KEY_TITLE to data.model.title)
        findNavController().navigate(R.id.articleDetailFragment, bundle, navOptions)
    }

    abstract fun favoriteAction(data: ArticleClickPayload.FavoriteAction)
}