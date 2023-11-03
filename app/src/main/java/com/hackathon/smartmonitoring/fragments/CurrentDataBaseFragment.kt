package com.hackathon.smartmonitoring.fragments

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.hackathon.smartmonitoring.adapter.CurrentDataBaseKotlinAdapter
import com.hackathon.smartmonitoring.databinding.CurrentDatabaseFragmentBinding
import com.hackathon.smartmonitoring.network.response.LogsResponse
import com.hackathon.smartmonitoring.presenter.GetLogPresenter
import com.hackathon.smartmonitoring.ui.recycler.adapter.AdapterLogsDataBase
import com.hackathon.smartmonitoring.view.GetLogView
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class CurrentDataBaseFragment : Fragment(), GetLogView {
    private val binding: CurrentDatabaseFragmentBinding by lazy {
        CurrentDatabaseFragmentBinding.inflate(layoutInflater)
    }
    private val adapterLogsDataBase: AdapterLogsDataBase by lazy {
        AdapterLogsDataBase()
    }
    private var rotateAnimator: ValueAnimator? = null
    private var presenter: GetLogPresenter? = null
    private var adapter: CurrentDataBaseKotlinAdapter? =null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
    private fun startRotationAnimation() {
        rotateAnimator = ValueAnimator.ofFloat(0f, 360f)
        rotateAnimator?.interpolator = LinearInterpolator()
        rotateAnimator?.duration = 1000
        rotateAnimator?.repeatCount = ValueAnimator.INFINITE
        rotateAnimator?.addUpdateListener { valueAnimator ->
            val rotation = valueAnimator.animatedValue as Float
            binding.imageRefresh.rotation = rotation
        }
        rotateAnimator?.start()
    }

    private fun stopRotationAnimation() {
        if (rotateAnimator != null && rotateAnimator!!.isRunning) {
            rotateAnimator!!.cancel()
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        presenter = GetLogPresenter(this)

        presenter?.getLogs()

        binding.refreshBtn.setOnClickListener(View.OnClickListener { l: View? ->
            startRotationAnimation()
            presenter?.getLogs()
        })

        binding.recyclerLog.adapter = adapterLogsDataBase

        binding.swipeRefresh.setOnRefreshListener {
            lifecycleScope.launch {
                delay(1000)
                presenter?.getLogs()
                binding.swipeRefresh.isRefreshing = false
            }
        }

    }

    override fun errorMessage(msg: String?) {
        TODO("Not yet implemented")
    }

    override fun getLogsFromService(data: MutableList<LogsResponse>?) {
        stopRotationAnimation()
        adapter = context?.let { CurrentDataBaseKotlinAdapter(data, it) }

    }

}