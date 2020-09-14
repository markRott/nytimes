package com.example.newyorktimesapp.entities.comments.dto

import com.example.newyorktimesapp.entities.comments.ui.CommentResultUI
import com.example.newyorktimesapp.entities.comments.ui.CommentUI

private fun CommentDto.toDomain(): CommentUI = CommentUI(
    commentID = commentID,
    userID = userID,
    userDisplayName = userDisplayName ?: "",
    userLocation = userLocation ?: "",
    userTitle = userTitle ?: "",
    userURL = userURL ?: "",
    picURL = picURL ?: "",
    commentTitle = commentTitle ?: "",
    commentBody = commentBody ?: "",
    createDate = createDate ?: ""
)

fun CommentResultDto.toDomain() : CommentResultUI = CommentResultUI(
    comments = comments?.toDomain() ?: emptyList(),
    page = page ?: 0,
    totalCommentsFound = totalCommentsFound ?: 0
)

fun List<CommentDto>.toDomain() : List<CommentUI> = this.map { it.toDomain() }