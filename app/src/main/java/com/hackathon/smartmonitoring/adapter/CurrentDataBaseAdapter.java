package com.hackathon.smartmonitoring.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.smartmonitoring.R;
import com.hackathon.smartmonitoring.network.response.LogsResponse;

import java.util.List;

public class CurrentDataBaseAdapter extends RecyclerView.Adapter<CurrentDataBaseAdapter.LabelHolder> {
    public List<LogsResponse> data;
    public Context context;

    public CurrentDataBaseAdapter(List<LogsResponse> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public CurrentDataBaseAdapter.LabelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_log, parent, false);
        return new LabelHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentDataBaseAdapter.LabelHolder holder, int position) {
        holder.status.setText(data.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class LabelHolder extends RecyclerView.ViewHolder {
        TextView time, date, status;
        public LabelHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            date = itemView.findViewById(R.id.date);
            status = itemView.findViewById(R.id.status);
        }
    }
}
