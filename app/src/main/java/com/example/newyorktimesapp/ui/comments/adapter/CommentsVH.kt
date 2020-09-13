package com.example.newyorktimesapp.ui.comments.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.newyorktimesapp.R
import com.example.newyorktimesapp.entities.comments.ui.CommentUI
import com.example.newyorktimesapp.utils.loadImage
import kotlinx.android.synthetic.main.item_comment.view.*

class CommentsVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(model: CommentUI) {
        val ctx = itemView.context

        if (model.picURL.isNotEmpty()) {
            itemView.iv_avatar.loadImage(model.picURL)
        } else itemView.iv_avatar.setImageResource(R.drawable.stub_avatar)

        itemView.tv_name.text = model.userDisplayName
        itemView.tv_geo_and_date.text = ctx.getString(R.string.comments_geo_and_date, model.userLocation, model.createDate)
        itemView.tv_comment_body.text = model.commentBody
    }
}