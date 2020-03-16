package com.example.newsapp.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsFragmentBinding
import com.example.newsapp.di.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class NewsFragment : DaggerFragment() {

    private lateinit var viewModel: NewsViewModel

    @Inject
    lateinit var factory: ViewModelProviderFactory

    private val adapter = NewsAdapter(ClickListener {

    })
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: NewsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.news_fragment,
            container, false)

        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this, factory)
            .get(NewsViewModel::class.java)

        binding.newsRv.adapter = adapter

        viewModel.news.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        return binding.root
    }

}
