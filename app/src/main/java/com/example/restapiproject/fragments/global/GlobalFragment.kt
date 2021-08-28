package com.example.restapiproject.fragments.global

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.restapiproject.R
import com.example.restapiproject.databinding.FragmentGlobalBinding
import com.example.restapiproject.model.GlobalResult
import com.example.restapiproject.retrofit.ApiClient
import com.example.restapiproject.ui.networkGlobal.NetworkHelperForGlobal
import com.example.restapiproject.ui.networkGlobal.NetworkListenerForGlobal

class GlobalFragment : Fragment(R.layout.fragment_global), NetworkListenerForGlobal {

    private lateinit var binding: FragmentGlobalBinding
    private lateinit var networkHelperForGlobal: NetworkHelperForGlobal

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentGlobalBinding.bind(view)

        networkHelperForGlobal = NetworkHelperForGlobal(ApiClient.getClient())
        setDate()

    }

    private fun setDate() {
        networkHelperForGlobal.getGlobalResult(this)
    }

    override fun onGlobalResultResponses(models: GlobalResult?) {
        binding.cvGlobalCasesCount.text = models?.cases.toString()
        binding.cvGlobalDeathsCount.text = models?.deaths.toString()
        binding.cvGlobalRecoveredCount.text = models?.recovered.toString()
    }

    override fun onGlobalResultFailure(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}