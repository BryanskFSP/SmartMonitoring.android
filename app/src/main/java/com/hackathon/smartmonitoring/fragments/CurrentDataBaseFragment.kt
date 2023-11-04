package com.hackathon.smartmonitoring.fragments

import android.animation.ValueAnimator
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.hackathon.smartmonitoring.activity.MainActivity
import com.hackathon.smartmonitoring.databinding.CurrentDatabaseFragmentBinding
import com.hackathon.smartmonitoring.dialog.InfoErrorDialog
import com.hackathon.smartmonitoring.network.response.LogsResponse
import com.hackathon.smartmonitoring.presenter.GetLogPresenter
import com.hackathon.smartmonitoring.ui.recycler.adapter.AdapterLogsDataBase
import com.hackathon.smartmonitoring.ui.recycler.models.LogDataBase
import com.hackathon.smartmonitoring.util.FormatterDateAndTime
import com.hackathon.smartmonitoring.view.GetLogView
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class CurrentDataBaseFragment : Fragment(), GetLogView {
    private val binding: CurrentDatabaseFragmentBinding by lazy {
        CurrentDatabaseFragmentBinding.inflate(layoutInflater)
    }
    private val adapterLogsDataBase: AdapterLogsDataBase by lazy {
        AdapterLogsDataBase(object : AdapterLogsDataBase.OnClick {
            override fun onClickItem(id: String) {
                val dialog =InfoErrorDialog(id)
                dialog.isCancelable = true
                dialog.show(childFragmentManager, "lol")
            }
        })
    }
    private var rotateAnimator: ValueAnimator? = null
    private var presenter: GetLogPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        presenter = GetLogPresenter(this)

        initRecycler()

        binding.swipeRefresh.setOnRefreshListener {
            lifecycleScope.launch {
                delay(1000)
                presenter?.getLogs()
                binding.swipeRefresh.isRefreshing = false
            }
        }

        binding.refreshBtn.setOnClickListener {
            startRotationAnimation()
            presenter?.getLogs()
        }

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

    override fun errorMessage(msg: String?) {
        Toast.makeText(requireActivity(), msg, Toast.LENGTH_SHORT).show()
        stopRotationAnimation()
        binding.progress.visibility = View.GONE
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getLogsFromService(data: MutableList<LogsResponse>?) {
        data?.let {
            adapterLogsDataBase.list = logsResponseToLogDataBase(it)
        }
        stopRotationAnimation()
        binding.progress.visibility = View.GONE
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun logsResponseToLogDataBase(logsResponse: List<LogsResponse>): List<LogDataBase> {
        return logsResponse.map {
            val dateAndTime = FormatterDateAndTime().format(it.entityID)
            LogDataBase(
                id = it.id,
                time = dateAndTime.time,
                date = dateAndTime.date,
                statusText = it.description,
                logType = it.logType
            )
        }
    }

    private fun initRecycler() {
        presenter?.getLogs()
        binding.recyclerLog.adapter = adapterLogsDataBase
    }

}