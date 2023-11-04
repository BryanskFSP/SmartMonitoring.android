package com.hackathon.smartmonitoring.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.Fragment
import com.hackathon.smartmonitoring.R
import com.hackathon.smartmonitoring.databinding.ProfFragmentBinding
import com.hackathon.smartmonitoring.network.response.LogFullResponse
import com.hackathon.smartmonitoring.presenter.GetLogPresenter
import com.hackathon.smartmonitoring.presenter.ProfPresenter
import com.hackathon.smartmonitoring.view.ProfView

class ProfFragment : Fragment() , ProfView {
    private val binding: ProfFragmentBinding by lazy { ProfFragmentBinding.inflate(layoutInflater) }

    private var presenter: ProfPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = ProfPresenter(this)

        presenter?.getFullLogInfo();
    }

    override fun getLogInfo(data: LogFullResponse?) {
        binding.city.text = data?.dataBase?.name
        binding.nameDb.text = data?.dataBase?.database
        binding.errors.text = data?.description

        if(data?.logType.equals("error")){
            context?.let { binding.errors.setTextColor(it.getColor(R.color.red)) }
        } else context?.let { binding.errors.setTextColor(it.getColor(R.color.greeen)) }

        binding.time.text = data?.createdAt?.substring(data?.createdAt!!.length-15, data?.createdAt!!.length-7)
        dismissProgress()
        showInfo()
    }

    override fun errorMessage(msg: String?) {
       Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showInfo() {
        binding.city.visibility = View.VISIBLE
        binding.nameDb.visibility = View.VISIBLE
        binding.cardError.visibility = View.VISIBLE
    }

    fun dismissProgress() {
        binding.progress.visibility = View.GONE
    }
}