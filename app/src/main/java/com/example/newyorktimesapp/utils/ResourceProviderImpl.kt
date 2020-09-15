package com.example.newyorktimesapp.utils

import android.content.Context
import android.content.res.Resources
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes

interface ResourcesProvider {

    @Throws(IllegalArgumentException::class)
    fun getString(@StringRes id: Int): String

    @Throws(IllegalArgumentException::class)
    fun getString(@StringRes id: Int, vararg formatArgs: Any): String

    @Throws(IllegalArgumentException::class)
    fun getStringArray(@ArrayRes id: Int): Array<String>
}

class ResourceProviderImpl(context: Context) : ResourcesProvider {

    private val resolver = context.applicationContext.resources

    override fun getString(@StringRes id: Int): String = try {
        resolver.getString(id)
    } catch (ex: Resources.NotFoundException) {
        throw IllegalArgumentException(ex)
    }

    override fun getString(@StringRes id: Int, vararg formatArgs: Any): String = try {
        resolver.getString(id, *formatArgs)
    } catch (ex: Resources.NotFoundException) {
        throw IllegalArgumentException(ex)
    }

    override fun getStringArray(@ArrayRes id: Int): Array<String> = try {
        resolver.getStringArray(id)
    } catch (ex: Resources.NotFoundException) {
        throw IllegalArgumentException(ex)
    }
}