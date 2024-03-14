package com.course.qoutepaging

import android.content.Context

/**
 *hrahm,08/03/2024, 19:40
 **/
object Injection {
    fun provideRepository(context: Context): QuoteRepository {
        val apiService = ApiConfig.getApiService()
        return QuoteRepository(apiService)
    }
}