package com.hackathon.smartmonitoring.ui.recycler.diffutilcallback

import androidx.recyclerview.widget.DiffUtil
import com.hackathon.smartmonitoring.ui.recycler.models.DataBase

class CallbackDataBase (
    private val oldItems: List<DataBase>,
    private val newItems: List<DataBase>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition].name == newItems[newItemPosition].name

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItems[oldItemPosition] == newItems[newItemPosition]
}