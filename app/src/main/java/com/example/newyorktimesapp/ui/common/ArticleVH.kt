package com.example.newyorktimesapp.ui.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.newyorktimesapp.R
import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI
import com.example.newyorktimesapp.utils.loadImage
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleVH(itemView: View, val onItemClick: (ArticleClickPayload) -> Unit) : RecyclerView.ViewHolder(itemView) {

    fun bind(model: ArticleUI, isFavorite: Boolean) {
        loadImage(model)
        itemView.tv_copyright.text = model.copyright
        itemView.tv_title.text = model.title
        itemView.tv_sub_title.text = model.subTitle
        itemView.tv_author.text = model.byline
        val context = itemView.context
        itemView.tv_published.text = context.getString(R.string.published, model.publishedDate)
        itemView.iv_favorite_action.isSelected = isFavorite

        itemView.setOnClickListener { onItemClick(ArticleClickPayload.openArticleAction(model)) }
        commentsAction(model)
        favoriteAction(model)
    }

    private fun loadImage(model: ArticleUI) {
        if (model.imageUrl.isNotEmpty()) {
            itemView.iv_article.loadImage(model.imageUrl)
        } else itemView.iv_article.setImageResource(R.drawable.no_image)
    }

    private fun favoriteAction(model: ArticleUI) {
        itemView.iv_favorite_action.setOnClickListener {
            it.isSelected = !it.isSelected
            onItemClick(ArticleClickPayload.favoriteAction(model, it.isSelected))
        }
    }

    private fun commentsAction(model: ArticleUI) {
        itemView.tv_comments.setOnClickListener {
            onItemClick(ArticleClickPayload.commentsAction(model))
        }
    }
}