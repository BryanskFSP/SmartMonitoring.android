package com.hackathon.smartmonitoring.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.hackathon.smartmonitoring.R;
import com.hackathon.smartmonitoring.network.response.LogsResponse;
import com.hackathon.smartmonitoring.presenter.InfoErrorPresenter;
import com.hackathon.smartmonitoring.ui.recycler.models.LogDataBase;
import com.hackathon.smartmonitoring.util.SharedPref;
import com.hackathon.smartmonitoring.view.InfoErrorView;

public class SimpleInfoErrorDialog extends BottomSheetDialogFragment implements InfoErrorView {

    public InfoErrorPresenter presenter;
    public String names, descriptions;
    public boolean chaangeds;

    public SimpleInfoErrorDialog(String names, String descriptions, boolean chaangeds) {
        this.names = names;
        this.descriptions = descriptions;
        this.chaangeds = chaangeds;
    }

    TextView name, description, change;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.info_error_dialog, container, false);

        presenter = new InfoErrorPresenter(this);

        name = v.findViewById(R.id.error_name);
        description = v.findViewById(R.id.description);
        change = v.findViewById(R.id.change_btn);

        initInfo(names, descriptions, chaangeds);

        change.setOnClickListener(l->{
            presenter.killProcess(SharedPref.getIdDataBase());
        });

        return v;
    }

    public void initInfo(String namess, String descriptionss, boolean changeds) {
        name.setText(namess);
        description.setText(descriptionss);
        change.setVisibility(changeds? View.GONE : View.VISIBLE);
    }

    @Override
    public void errorMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInfo(LogsResponse log) {

    }
}
