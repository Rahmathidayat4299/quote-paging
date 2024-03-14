package com.course.qoutepaging

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.course.qoutepaging.databinding.ItemQuoteBinding

/**
 *hrahm,08/03/2024, 19:38
 **/
class QuoteListAdapter :
    PagingDataAdapter<QuoteResponseItem, QuoteListAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemQuoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
            Log.d("QuoteItem", "Title: ${data.title}")
        }
    }

    class MyViewHolder(private val binding: ItemQuoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: QuoteResponseItem) {
            binding.tvItemQuote.text = data.title
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<QuoteResponseItem>() {
            override fun areItemsTheSame(
                oldItem: QuoteResponseItem,
                newItem: QuoteResponseItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: QuoteResponseItem,
                newItem: QuoteResponseItem
            ): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}