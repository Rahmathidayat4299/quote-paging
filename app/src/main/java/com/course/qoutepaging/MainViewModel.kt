package com.course.qoutepaging

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.launch

/**
 *hrahm,08/03/2024, 19:42
 **/
class MainViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    private val _quote = MutableLiveData<List<QuoteResponseItem>>()


    val quote: LiveData<PagingData<QuoteResponseItem>> =
        quoteRepository.getQuote().cachedIn(viewModelScope)
}

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(Injection.provideRepository(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}