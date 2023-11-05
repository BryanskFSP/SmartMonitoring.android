package com.hackathon.smartmonitoring.fragments.otchet;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hackathon.smartmonitoring.R;
import com.hackathon.smartmonitoring.adapter.IndexAdapter;
import com.hackathon.smartmonitoring.adapter.IndexOldAdapter;
import com.hackathon.smartmonitoring.fragments.BaseFragment;
import com.hackathon.smartmonitoring.network.response.DataIndex;
import com.hackathon.smartmonitoring.network.response.DataIndexOld;
import com.hackathon.smartmonitoring.presenter.IndexOtchetPresenter;
import com.hackathon.smartmonitoring.util.SharedPref;
import com.hackathon.smartmonitoring.view.IndexOtchetView;

import java.util.List;

import butterknife.BindView;

public class IndexOtchetFragment extends BaseFragment implements IndexOtchetView {
    public static final String OLD = "old";
    public IndexOtchetPresenter presenter;
    @BindView(R.id.back_arrow)
    ImageView back;
    @BindView(R.id.rv)
    RecyclerView rv;
    public IndexAdapter adapter;
    public IndexOldAdapter oldAdapter;

    public static IndexOtchetFragment newInstance(boolean old) {

        Bundle args = new Bundle();
        args.putBoolean(OLD, old);

        IndexOtchetFragment fragment = new IndexOtchetFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected void initViews() {
        super.initViews();
        presenter = new IndexOtchetPresenter(this);
        if(getArguments().getBoolean(OLD, true)){
            presenter.getOldIndexes(SharedPref.getIdDataBase());
        } else presenter.getSimpleIndexes(SharedPref.getIdDataBase());

        back.setOnClickListener(l->{
            getActivity().getSupportFragmentManager().popBackStack();
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.index_otchet_fragment;
    }

    @Override
    public void getIndexSimple(List<DataIndex> data) {
        if(data!=null){
            adapter = new IndexAdapter(data, getContext());
            rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true));
            rv.setAdapter(adapter);
        }
    }

    @Override
    public void getIndexOld(List<DataIndexOld> data) {
        if(data!=null){
            oldAdapter = new IndexOldAdapter(data, getContext());
            rv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true));
            rv.setAdapter(adapter);
        }
    }

    @Override
    public void errorMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
