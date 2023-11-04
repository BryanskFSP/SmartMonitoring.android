package com.hackathon.smartmonitoring.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hackathon.smartmonitoring.databinding.CheckingFragmentBinding

class CheckingFragment: Fragment() {
    private val binding by lazy { CheckingFragmentBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initButtons()
    }

    private fun initButtons() {
        with(binding) {
            checkBlockage.setOnClickListener {}
            checkSpace.setOnClickListener {}
            checkCash.setOnClickListener {}
            checkCashIndex.setOnClickListener {}
        }
    }
}