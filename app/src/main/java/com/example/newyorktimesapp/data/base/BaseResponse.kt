package com.example.newyorktimesapp.data.base

import com.google.gson.annotations.SerializedName

open class BaseResponse<T>(
    @SerializedName("status")
    val status: String?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("results")
    val results: T?
)