package com.example.newyorktimesapp.ui.mostpopular.adapter

import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI

sealed class ArticleClickPayload {

    companion object {
        fun openArticleAction(model: ArticleUI) = ArticleAction(model)
        fun commentsAction(model: ArticleUI) = CommentsAction(model)
        fun favoriteAction(model: ArticleUI, favoriteState: Boolean) = FavoriteAction(model, favoriteState)
    }

    class ArticleAction(val model: ArticleUI) : ArticleClickPayload()
    class CommentsAction(val model: ArticleUI) : ArticleClickPayload()
    class FavoriteAction(val model: ArticleUI, val favoriteState: Boolean) : ArticleClickPayload()
}