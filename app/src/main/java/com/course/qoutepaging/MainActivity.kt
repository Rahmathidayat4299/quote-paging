package com.course.qoutepaging

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.course.qoutepaging.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val mainViewModel: MainViewModel by viewModels {
        ViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvQuote.layoutManager = LinearLayoutManager(this)

        getData()
    }

    private fun getData() {
        val adapter = QuoteListAdapter()
        binding.rvQuote.adapter = adapter
        mainViewModel.quote.observe(this, {
            adapter.submitData(lifecycle, it)
            Log.d("List", "getData: ${it}}")
        })
    }
}