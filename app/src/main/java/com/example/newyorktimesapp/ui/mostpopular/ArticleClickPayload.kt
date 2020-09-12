package com.example.newyorktimesapp.ui.mostpopular

import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularArticleUI

sealed class ArticleClickPayload {

    companion object {
        fun openArticleAction(model: MostPopularArticleUI) = ArticleAction(model)
        fun commentsAction(model: MostPopularArticleUI) = CommentsAction(model)
        fun favoriteAction(model: MostPopularArticleUI, favoriteState: Boolean) = FavoriteAction(model, favoriteState)
    }

    class ArticleAction(val model: MostPopularArticleUI) : ArticleClickPayload()
    class CommentsAction(val model: MostPopularArticleUI) : ArticleClickPayload()
    class FavoriteAction(val model: MostPopularArticleUI, val favoriteState: Boolean) : ArticleClickPayload()
}