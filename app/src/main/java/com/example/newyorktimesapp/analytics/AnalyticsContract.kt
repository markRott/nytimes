package com.example.newyorktimesapp.analytics

interface AnalyticsContract {

    fun logEvent(key: String, value: String)
}