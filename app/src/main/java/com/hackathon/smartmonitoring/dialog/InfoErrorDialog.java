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

public class InfoErrorDialog extends BottomSheetDialogFragment implements InfoErrorView {
    final private LogDataBase log;
    public InfoErrorPresenter presenter;

    public InfoErrorDialog(LogDataBase log) {
        this.log = log;
    }
    TextView name, description, change;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.info_error_dialog, container, false);

        presenter = new InfoErrorPresenter(this);

        name = v.findViewById(R.id.error_name);
        description = v.findViewById(R.id.description);
        change = v.findViewById(R.id.change_btn);

        initInfo(this.log);

        change.setOnClickListener(l->{
//            presenter.killProcess();
            presenter.killProcess(SharedPref.getIdDataBase());
        });

        return v;
    }

    public void initInfo(LogDataBase log) {
        name.setText(log.getAction());
        description.setText(log.getStatusText());
        change.setVisibility(log.isFixStatus()? View.VISIBLE :  View.GONE);
    }

    @Override
    public void errorMessage(String msg) {
        Toast.makeText(getContext(), msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInfo(LogsResponse log) {

    }
}
