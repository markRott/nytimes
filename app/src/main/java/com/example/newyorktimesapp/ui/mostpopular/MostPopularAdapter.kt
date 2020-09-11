package com.example.newyorktimesapp.ui.mostpopular

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newyorktimesapp.R
import com.example.newyorktimesapp.entities.mostpopular.ui.MostPopularArticleUI
import com.example.newyorktimesapp.utils.inflate

class MostPopularAdapter : RecyclerView.Adapter<MostPopularVH>() {

    private val items = mutableListOf<MostPopularArticleUI>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularVH =
        MostPopularVH(parent.inflate(R.layout.item_most_popular))

    override fun onBindViewHolder(holder: MostPopularVH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(articles: List<MostPopularArticleUI>) {
        items.clear()
        items.addAll(articles)
        notifyDataSetChanged()
    }
}