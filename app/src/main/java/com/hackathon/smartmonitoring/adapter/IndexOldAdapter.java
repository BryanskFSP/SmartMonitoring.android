package com.hackathon.smartmonitoring.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.smartmonitoring.R;
import com.hackathon.smartmonitoring.network.response.DataIndexOld;

import java.util.List;

public class IndexOldAdapter extends RecyclerView.Adapter<IndexOldAdapter.LabelHolder> {
    public List<DataIndexOld> data;
    public Context context;

    public IndexOldAdapter(List<DataIndexOld> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public IndexOldAdapter.LabelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.index_old_item , parent, false);
        return new LabelHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull IndexOldAdapter.LabelHolder holder, int position) {
        holder.one.setText("Index name: "+ data.get(position).getIndexrelname());
        holder.two.setText("Relname: "+ data.get(position).getRelname());
        holder.three.setText("Stats: "+ data.get(position).getStats());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class LabelHolder extends RecyclerView.ViewHolder {
        TextView one, two, three;
        public LabelHolder(@NonNull View itemView) {
            super(itemView);
            one = itemView.findViewById(R.id.first);
            two = itemView.findViewById(R.id.second);
            three = itemView.findViewById(R.id.threed);
        }
    }
}
