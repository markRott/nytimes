package com.example.newyorktimesapp.ui.comments.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.example.newyorktimesapp.R
import com.example.newyorktimesapp.entities.comments.ui.CommentUI
import com.example.newyorktimesapp.utils.inflate

class CommentsAdapter() : PagedListAdapter<CommentUI, CommentsVH>(CommentDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsVH =
        CommentsVH(parent.inflate(R.layout.item_comment))

    override fun onBindViewHolder(holder: CommentsVH, position: Int) {
        val model = getItem(position)
        model?.let { holder.bind(it) }
    }
}