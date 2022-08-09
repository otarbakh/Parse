package com.example.parse

import android.graphics.Color
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parse.databinding.FragmentSecondDestinationBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

const val Tag = "tag"

@Suppress("DeferredResultUnused")

class SecondDestination : Fragment() {
    private var _binding: FragmentSecondDestinationBinding? = null
    private val binding get() = _binding!!
    private val homeAdapter: Adapter by lazy { Adapter() }

    val viewModel: SecondDestinationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondDestinationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        heandling()
    }

    private fun heandling() {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.data.collectLatest {
                    when (it) {
                        is Resource.Success -> {
                            homeAdapter.submitList(it.data)
                            Log.d(Tag, "Success")
                        }
                        is Resource.Error -> {
                            Log.d(tag, "${it.error}")
                        }
                        is Resource.Loader -> {
                            if (it.isLoading) {
                                binding.tvLoading

                            } else {
                                binding.rvRecycler.setBackgroundColor(Color.GREEN)
                            }
                        }
                    }
                }
            }
        }



    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecycler() {
        binding.rvRecycler.apply {
            adapter = homeAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        viewModel.getMyData()

    }


}