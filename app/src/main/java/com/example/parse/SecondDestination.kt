package com.example.parse

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parse.databinding.FragmentSecondDestinationBinding
import kotlinx.coroutines.launch

class SecondDestination : Fragment() {
    private var _binding: FragmentSecondDestinationBinding? = null
    private val binding get() = _binding!!
    private val homeAdapter: Adapter by lazy { Adapter() }

    val viewModel:SecondDestinationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondDestinationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        viewLifecycleOwner.lifecycleScope.launch() {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.data.collect {
                    homeAdapter.submitList(it)
                }
            }
        }
    }

    private fun setupRecycler() {
        binding.recycler.apply {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        }
        viewModel.getHomesData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}