package com.hackathon.smartmonitoring.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hackathon.smartmonitoring.R
import com.hackathon.smartmonitoring.databinding.CheckingFragmentBinding
import com.hackathon.smartmonitoring.presenter.CheckingPresenter
import com.hackathon.smartmonitoring.util.SharedPref
import com.hackathon.smartmonitoring.util.SnackBarUtil
import com.hackathon.smartmonitoring.view.ChekingView

class CheckingFragment: Fragment(), ChekingView {
    private val binding by lazy { CheckingFragmentBinding.inflate(layoutInflater) }

    private var presenter: CheckingPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter = CheckingPresenter(this)
        initButtons()
    }

    private fun initButtons() {
        with(binding) {
            checkBlockage.setOnClickListener {presenter?.checkStates(SharedPref.getIdDataBase())}
            checkSpace.setOnClickListener {presenter?.checkMemory(SharedPref.getIdDataBase())}
            checkCash.setOnClickListener {presenter?.checkChachingratio(SharedPref.getIdDataBase())}
            checkCashIndex.setOnClickListener {presenter?.checkChachingratioIndex(SharedPref.getIdDataBase())}
        }
    }

    override fun checkMemory(msg: String?) {
        msg?.let { handlerSnackBar(it) }
    }

    override fun checkStates(msg: String?) {
        msg?.let { handlerSnackBar(it) }
    }

    override fun checkChachingratio(msg: String?) {
        msg?.let { handlerSnackBar(it) }
    }

    override fun checkChachingratioIndex(msg: String?) {
        msg?.let { handlerSnackBar(it) }
    }

    fun handlerSnackBar(msg: String){
        val util = SnackBarUtil.make(requireActivity().findViewById(R.id.fragment_containe))
            .setMessage(msg)
        val snackBarView = util.view
        snackBarView.setBackgroundColor(Color.TRANSPARENT)
        util.show()
    }
    override fun errorMessage(msg: String?) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}