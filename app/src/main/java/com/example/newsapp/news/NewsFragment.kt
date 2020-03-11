package com.example.newsapp.news

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.example.newsapp.R
import com.example.newsapp.databinding.NewsFragmentBinding

class NewsFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: NewsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.news_fragment,
            container, false)

        binding.lifecycleOwner = this

        binding.text.setOnClickListener {
            this.findNavController()
                .navigate(NewsFragmentDirections.actionNewsFragmentToNewsDetailsFragment())
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
