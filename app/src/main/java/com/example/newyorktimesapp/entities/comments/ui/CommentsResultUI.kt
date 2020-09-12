package com.example.newyorktimesapp.entities.comments.ui


class CommentsResultUI(
    val comments: List<CommentUI> = emptyList(),
    val page: Int = 0,
    val totalCommentsFound: Int = 0
)