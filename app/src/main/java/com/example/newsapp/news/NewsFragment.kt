package com.example.newsapp.news

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.newsapp.R
import com.example.newsapp.databinding.NewsFragmentBinding
import com.example.newsapp.di.ViewModelProviderFactory
import com.example.newsapp.newsdetails.NewsDetailsViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class NewsFragment : DaggerFragment() {

    private lateinit var viewModel: NewsViewModel

    @Inject
    lateinit var factory: ViewModelProviderFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: NewsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.news_fragment,
            container, false)

        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this, factory)
            .get(NewsViewModel::class.java)

        return binding.root
    }

}
