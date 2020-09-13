package com.example.newyorktimesapp.data.base

import android.util.Log
import retrofit2.Response

abstract class BaseRepository {

    protected suspend fun <T> getResult(action: suspend () -> Response<T>): Result<T> {
        try {
            val response = action()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.success(body)
            }
            val msg = "${response.code()} ${response.message()}"
            return error(msg)
        } catch (e: Exception) {
            Log.e("BaseRepository", "Get result exception: ", e)
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        val finalMsg = "Network call has failed for a following reason: $message"
        Log.e("BaseRepository", finalMsg)
        return Result.error(finalMsg)
    }
}