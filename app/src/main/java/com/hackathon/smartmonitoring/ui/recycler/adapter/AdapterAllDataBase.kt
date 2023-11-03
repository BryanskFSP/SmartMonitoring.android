package com.hackathon.smartmonitoring.ui.recycler.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.smartmonitoring.databinding.ItemDbBinding
import com.hackathon.smartmonitoring.ui.recycler.diffutilcallback.CallbackDataBase
import com.hackathon.smartmonitoring.ui.recycler.models.DataBase

class AdapterAllDataBase : RecyclerView.Adapter<AdapterAllDataBase.Holder>() {
    class Holder(
        val binding: ItemDbBinding
        ): RecyclerView.ViewHolder(binding.root)

    var list: List<DataBase> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            val callback = CallbackDataBase(
                oldItems = field,
                newItems = value
            )
            field = value
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDbBinding.inflate(inflater, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val itemOfList = list[position]

        with(holder.binding) {
            db.text = itemOfList.name
            checkbox.isChecked = itemOfList.check
        }
    }

    override fun getItemCount(): Int =
        list.size
}