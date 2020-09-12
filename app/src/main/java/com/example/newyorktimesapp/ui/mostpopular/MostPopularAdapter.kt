package com.example.newyorktimesapp.ui.mostpopular

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newyorktimesapp.R
import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularArticleUI
import com.example.newyorktimesapp.utils.inflate

class MostPopularAdapter(private val onItemClick: (ArticleClickPayload) -> Unit) :
    RecyclerView.Adapter<MostPopularVH>() {

    private val favoriteIds = mutableSetOf<Long>()
    private val items = mutableListOf<MostPopularArticleUI>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularVH =
        MostPopularVH(parent.inflate(R.layout.item_most_popular), onItemClick)

    override fun onBindViewHolder(holder: MostPopularVH, position: Int) {
        val model = items[position]
        holder.bind(model, favoriteIds.contains(model.id))
    }

    override fun getItemCount(): Int = items.size

    fun setArticleItems(articles: List<MostPopularArticleUI>) {
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