package com.example.newyorktimesapp.ui.comments.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.newyorktimesapp.entities.comments.ui.CommentUI

class CommentDiffUtil : DiffUtil.ItemCallback<CommentUI>() {

    override fun areItemsTheSame(oldItem: CommentUI, newItem: CommentUI): Boolean =
        oldItem.commentID == newItem.commentID

    override fun areContentsTheSame(oldItem: CommentUI, newItem: CommentUI): Boolean =
        oldItem == newItem
}