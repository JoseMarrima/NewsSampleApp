package com.example.newsapp.newsdetails

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsDetailsFragmentBinding
import com.example.newsapp.di.ViewModelProviderFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class NewsDetailsFragment : DaggerFragment() {

    private lateinit var viewModel: NewsDetailsViewModel

    @Inject
    lateinit var factory: ViewModelProviderFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val binding: NewsDetailsFragmentBinding = DataBindingUtil.inflate(inflater,
                R.layout.news_details_fragment, container, false)

        viewModel = ViewModelProvider(this, factory)
            .get(NewsDetailsViewModel::class.java)

        setHasOptionsMenu(true)

        val args = NewsDetailsFragmentArgs.fromBundle(requireArguments())

        binding.news = args.news

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.details_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}
