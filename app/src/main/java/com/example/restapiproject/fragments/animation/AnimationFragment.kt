package com.example.restapiproject.fragments.animation

import android.animation.Animator
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.restapiproject.R
import com.example.restapiproject.databinding.FragmentAnimationBinding

class AnimationFragment : Fragment(R.layout.fragment_animation) {

    private lateinit var binding: FragmentAnimationBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAnimationBinding.bind(view)
        navController = Navigation.findNavController(view)

        requireActivity().actionBar?.hide()

        binding.coronaAnimation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                navController.navigate(R.id.action_animationFragment_to_mainFragment)
            }

            override fun onAnimationCancel(animation: Animator?) {}

            override fun onAnimationRepeat(animation: Animator?) {}

        })
    }
}