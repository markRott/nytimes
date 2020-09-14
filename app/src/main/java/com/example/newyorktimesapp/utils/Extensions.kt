package com.example.newyorktimesapp.utils

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
private val mm_dd_yyyy: SimpleDateFormat = SimpleDateFormat("MM.dd.yyyy")

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun ImageView.loadImage(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}

fun String.toHumanReadableDate(): String {
    return try {
        mm_dd_yyyy.format(Date(this.toLong() * 1000))
    } catch (e: Exception) {
        ""
    }
}