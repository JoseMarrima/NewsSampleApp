package com.example.newsapp.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.data.News
import com.example.newsapp.databinding.ListNewsItemCardBinding

class NewsAdapter(private val clickListener: ClickListener) :
    ListAdapter<News, RecyclerView.ViewHolder>(NewsDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsViewHolder(ListNewsItemCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewsViewHolder).bind(clickListener, getItem(position))
    }

    class NewsViewHolder(private val binding: ListNewsItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: ClickListener, item: News) {
            binding.apply {
                clickListener = listener
                news = item
                executePendingBindings()
            }
        }
    }
}

private class NewsDiffCallback : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }

}

class ClickListener(val clickListener: (news: News) -> Unit) {
    fun onClick(news: News) = clickListener(news)
}