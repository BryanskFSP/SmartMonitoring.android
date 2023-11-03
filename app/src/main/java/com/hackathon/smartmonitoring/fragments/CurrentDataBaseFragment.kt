package com.hackathon.smartmonitoring.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.hackathon.smartmonitoring.databinding.CurrentDatabaseFragmentBinding
import com.hackathon.smartmonitoring.ui.recycler.adapter.AdapterLogsDataBase
import com.hackathon.smartmonitoring.ui.recycler.models.LogDataBase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CurrentDataBaseFragment : Fragment() {
    private val binding: CurrentDatabaseFragmentBinding by lazy {
        CurrentDatabaseFragmentBinding.inflate(layoutInflater)
    }
    private val adapterLogsDataBase: AdapterLogsDataBase by lazy {
        AdapterLogsDataBase()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //<tests
        adapterLogsDataBase.list = listOf(
        )

        binding.recyclerLog.adapter = adapterLogsDataBase

        binding.swipeRefresh.setOnRefreshListener {
            lifecycleScope.launch {
                delay(1000)
                adapterLogsDataBase.list = listOf(
                    LogDataBase(
                        "12:00", "12.12.2023", false
                    ),
                    LogDataBase(
                        "12:02", "12.12.2023", true
                    ),
                    LogDataBase(
                        "12:03", "12.12.2023", false
                    ),
                    LogDataBase(
                        "12:12", "12.12.2023", false
                    ),
                    LogDataBase(
                        "12:32", "11.12.2023", true
                    )
                )
                binding.swipeRefresh.isRefreshing = false
            }
        }
        //tests>
    }
}