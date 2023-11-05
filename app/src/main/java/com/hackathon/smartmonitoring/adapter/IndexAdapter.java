package com.hackathon.smartmonitoring.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.smartmonitoring.R;
import com.hackathon.smartmonitoring.network.response.DataIndex;

import java.util.List;

public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.LabelHolder> {
    public List<DataIndex> data;
    public Context context;

    public IndexAdapter(List<DataIndex> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public IndexAdapter.LabelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate( R.layout.index_item, parent, false);
        return new LabelHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull IndexAdapter.LabelHolder holder, int position) {
        holder.one.setText("RealName: "+ data.get(position).getRelName());
        holder.two.setText("SeqScan: " + data.get(position).getSeqScan());
        holder.three.setText("IdxScan: " + data.get(position).getIdxScan());
        holder.two.setText("IndexStat: " + data.get(position).getIndexStat());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class LabelHolder extends RecyclerView.ViewHolder {
        TextView one, two, three, four;
        public LabelHolder(@NonNull View itemView) {
            super(itemView);
            one = itemView.findViewById(R.id.first);
            two = itemView.findViewById(R.id.second);
            three = itemView.findViewById(R.id.threed);
            four = itemView.findViewById(R.id.four);
        }
    }
}
