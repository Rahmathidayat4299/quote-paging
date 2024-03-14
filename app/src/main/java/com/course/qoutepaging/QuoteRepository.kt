package com.course.qoutepaging

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData

/**
 *hrahm,08/03/2024, 19:39
 **/
class QuoteRepository(private val apiService: ApiService) {

    fun getQuote(): LiveData<PagingData<QuoteResponseItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            pagingSourceFactory = {
                QuotePagingSource(apiService)
            }
        ).liveData
    }
}