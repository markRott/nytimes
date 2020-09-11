package com.example.newyorktimesapp.ui.mostpopular

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.newyorktimesapp.R
import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularArticleUI
import com.example.newyorktimesapp.utils.loadImage
import kotlinx.android.synthetic.main.item_most_popular.view.*

class MostPopularVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(model: MostPopularArticleUI) {
        if (model.getImageUrl().isNotEmpty()) {
            itemView.iv_article.loadImage(model.getImageUrl())
        } else {
            itemView.iv_article.setImageResource(R.drawable.no_image)
        }
        itemView.tv_copyright.text = model.getCopyright()
        itemView.tv_title.text = model.title
        itemView.tv_sub_title.text = model.abstract
        itemView.tv_author.text = model.byline
        itemView.tv_published.text = model.publishedDate
        itemView.tv_updated.text = model.updated
    }
}