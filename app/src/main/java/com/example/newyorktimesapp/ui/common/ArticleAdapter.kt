package com.example.newyorktimesapp.ui.common

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newyorktimesapp.R
import com.example.newyorktimesapp.entities.mostpopular.ui.ArticleUI
import com.example.newyorktimesapp.utils.inflate

class ArticleAdapter(private val onItemClick: (ArticleClickPayload) -> Unit) :
    RecyclerView.Adapter<ArticleVH>() {

    private val favoriteIds = mutableSetOf<Long>()
    private val items = mutableListOf<ArticleUI>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleVH =
        ArticleVH(parent.inflate(R.layout.item_article), onItemClick)

    override fun onBindViewHolder(holder: ArticleVH, position: Int) {
        val model = items[position]
        holder.bind(model, favoriteIds.contains(model.id))
    }

    override fun getItemCount(): Int = items.size

    fun setArticleItems(articles: List<ArticleUI>) {
        items.clear()
        items.addAll(articles)
        notifyDataSetChanged()
    }

    fun setFavoriteItems(favoriteIds: HashSet<Long>) {
        this.favoriteIds.clear()
        this.favoriteIds.addAll(favoriteIds)
        notifyDataSetChanged()
    }
}