package com.hackathon.smartmonitoring.ui.recycler.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.smartmonitoring.R
import com.hackathon.smartmonitoring.databinding.ItemLogBinding
import com.hackathon.smartmonitoring.ui.recycler.diffutilcallback.CallbackLogsDataBase
import com.hackathon.smartmonitoring.ui.recycler.models.LogDataBase

class AdapterLogsDataBase : RecyclerView.Adapter<AdapterLogsDataBase.Holder>() {
    private lateinit var context: Context

    class Holder(
        val binding: ItemLogBinding
    ): RecyclerView.ViewHolder(binding.root)

    var list: List<LogDataBase> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            val callback = CallbackLogsDataBase(
                oldItems = field,
                newItems = value
            )
            field = value
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLogBinding.inflate(inflater, parent, false)
        context = parent.context
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val itemOfList = list[position]

        with(holder.binding) {
            time.text = itemOfList.time
            date.text = itemOfList.date
            if (itemOfList.hasErrors) {
                status.text = context.getString(R.string.hasErrors)
                status.setTextColor(context.getColor(R.color.red))
            } else {
                status.text = context.getString(R.string.noErrors)
                status.setTextColor(context.getColor(R.color.greeen))
            }
        }
    }

    override fun getItemCount(): Int =
        list.size
}