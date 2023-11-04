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
import com.hackathon.smartmonitoring.view.InfoErrorView;

public class InfoErrorDialog extends BottomSheetDialogFragment implements InfoErrorView {

    public static final String ID_LOGS = "id_logs";
    public InfoErrorPresenter presenter;

    public static InfoErrorDialog newInstance(String id) {
        Bundle args = new Bundle();
        args.putString(ID_LOGS, id);
        InfoErrorDialog fragment = new InfoErrorDialog();
        fragment.setArguments(args);
        return fragment;
    }

    TextView name, description, change;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.info_error_dialog, container, false);
        presenter = new InfoErrorPresenter(this);

        name = v.findViewById(R.id.error_name);
        description = v.findViewById(R.id.description);
        change = v.findViewById(R.id.change_btn);

        if(!getArguments().getString(ID_LOGS,"").equals("")){
            presenter.getInfoError(getArguments().getString(ID_LOGS));
        }

        change.setOnClickListener(l->{
            //todo тут код на исправление будет
        });

        return v;
    }

    @Override
    public void errorMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInfo(LogsResponse log) {
        name.setText(log.getAction());
        description.setText(log.getDescription());
        change.setVisibility(log.isFixStatus()? View.VISIBLE : View.GONE);
    }
}
