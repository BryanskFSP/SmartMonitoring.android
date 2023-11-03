package com.hackathon.smartmonitoring.ui.recycler.diffutilcallback

import androidx.recyclerview.widget.DiffUtil
import com.hackathon.smartmonitoring.ui.recycler.models.LogDataBase

class CallbackLogsDataBase(
    private val oldItems: List<LogDataBase>,
    private val newItems: List<LogDataBase>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition] == newItems[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition] == newItems[newItemPosition]
}