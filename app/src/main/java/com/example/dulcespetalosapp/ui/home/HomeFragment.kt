package com.example.dulcespetalosapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.example.dulcespetalosapp.R
import com.example.dulcespetalosapp.data.api.Status
import com.example.dulcespetalosapp.databinding.HomeFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: HomeFragmentBinding
    private lateinit var adapter: ProductListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModelObservers()
        setListeners()
    }

    private fun setViewModelObservers() {
        viewModel.products.observe(viewLifecycleOwner, { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    adapter = ProductListAdapter(resource.data!!) { flowerId ->
                        navigateTo(
                            HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                                flowerId
                            )
                        )
                    }
                    adapter.notifyDataSetChanged()
                    setupListAdapter()
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    binding.listItem.recyclerView.visibility = View.GONE
                    binding.errorMessage.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.listItem.recyclerView.visibility = View.GONE
                }
            }
        })
    }

    private fun setListeners() = binding.searchBar.doOnTextChanged { text, _, _, _ ->
        viewModel.searchByName(text)
    }

    private fun setupListAdapter() {
        binding.progressBar.visibility = View.GONE
        binding.listItem.recyclerView.visibility = View.VISIBLE

        binding.listItem.recyclerView.adapter = adapter
    }

    private fun navigateTo(destination: NavDirections) =
        requireActivity().findNavController(R.id.navigation_fragment)
            .navigate(destination)

}