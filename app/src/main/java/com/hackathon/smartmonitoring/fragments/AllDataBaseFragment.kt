package com.hackathon.smartmonitoring.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.hackathon.smartmonitoring.databinding.AllDatabaseFragmentBinding
import com.hackathon.smartmonitoring.ui.recycler.adapter.AdapterAllDataBase
import com.hackathon.smartmonitoring.ui.recycler.models.DataBase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AllDataBaseFragment: Fragment() {

    private val binding: AllDatabaseFragmentBinding by lazy {
        AllDatabaseFragmentBinding.inflate(layoutInflater)
    }
    private val adapterAllDataBase:  AdapterAllDataBase by lazy {
        AdapterAllDataBase()
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
        adapterAllDataBase.list = listOf(
            DataBase(
                "5HOKN-93",
                true
            ),
            DataBase(
                "89HHFN-93",
                false
            ),DataBase(
                "676OOP-93",
                false
            )
        )

        binding.recyclerDb.adapter = adapterAllDataBase

        binding.swipeRefresh.setOnRefreshListener {
            lifecycleScope.launch {
                delay(1000)
                adapterAllDataBase.list = listOf(
                    DataBase(
                        "5HOKN-93",
                        true
                    ),DataBase(
                        "676OOP-93",
                        false
                    )
                )
                binding.swipeRefresh.isRefreshing = false
            }
        }
        //tests>
    }

    companion object {
        fun newInstance(): AllDataBaseFragment? {
            return AllDataBaseFragment()
        }
    }
}