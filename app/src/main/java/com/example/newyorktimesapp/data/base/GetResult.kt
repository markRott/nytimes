package com.example.newyorktimesapp.data.base

import android.util.Log
import com.example.newyorktimesapp.api.Result
import retrofit2.Response

const val TAG: String = "ApiInfo"

suspend fun <T> getResult(action: suspend () -> Response<T>): Result<T> {
    try {
        Log.d(TAG, Thread.currentThread().name)

        val response = action()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) return Result.success(body)
        }

        val finalMsg = error("${response.code()} ${response.message()}")
        return Result.error(finalMsg)

    } catch (e: Exception) {
        Log.e(TAG, "Get result exception: ", e)
        return Result.error(e.message ?: e.toString())
    }
}

private fun error(msg: String): String {
    val finalMsg = "Network call has failed for a following reason: $msg"
    Log.e(TAG, finalMsg)
    return finalMsg
}