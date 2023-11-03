package com.hackathon.smartmonitoring.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.smartmonitoring.R
import com.hackathon.smartmonitoring.network.response.LogsResponse

class CurrentDataBaseKotlinAdapter(private val data: MutableList<LogsResponse>?, private val context: Context) :
    RecyclerView.Adapter<CurrentDataBaseKotlinAdapter.LabelHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LabelHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_log, parent, false)
        return LabelHolder(view)
    }

    override fun onBindViewHolder(holder: LabelHolder, position: Int) {
        val logResponse = data?.get(position)
        if (logResponse != null) {
            holder.status.text = logResponse.description
        }
    }


    override fun getItemCount(): Int {
        return data!!.size
    }

    inner class LabelHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val time: TextView = itemView.findViewById(R.id.time)
        val date: TextView = itemView.findViewById(R.id.date)
        val status: TextView = itemView.findViewById(R.id.status)
    }
}