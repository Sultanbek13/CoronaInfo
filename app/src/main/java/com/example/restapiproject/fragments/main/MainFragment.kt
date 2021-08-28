package com.example.restapiproject.fragments.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.restapiproject.R
import com.example.restapiproject.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainer)
        binding.buttonNavigation.setupWithNavController(navController)

    }
}