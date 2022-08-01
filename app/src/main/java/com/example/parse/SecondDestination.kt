package com.example.parse

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.parse.databinding.FragmentSecondDestinationBinding

class SecondDestination : Fragment() {
    private var _binding: FragmentSecondDestinationBinding? = null
    private val binding get() = _binding!!


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
        viewModel.getMYmodel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}