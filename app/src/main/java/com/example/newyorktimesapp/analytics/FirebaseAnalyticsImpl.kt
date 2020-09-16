package com.example.newyorktimesapp.analytics

import androidx.core.os.bundleOf
import com.google.firebase.analytics.FirebaseAnalytics

class FirebaseAnalyticsImpl(private val analytics: FirebaseAnalytics) : AnalyticsContract {

    override fun logEvent(key: String, value: String) {
        val bundle = bundleOf(key to value)
        analytics.logEvent(key, bundle)
    }
}