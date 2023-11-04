package com.hackathon.smartmonitoring.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.hackathon.smartmonitoring.R;
import com.hackathon.smartmonitoring.ui.recycler.models.LogDataBase;

public class InfoErrorDialog extends BottomSheetDialogFragment {
    final private LogDataBase log;

    public InfoErrorDialog(LogDataBase log) {
        this.log = log;
    }
    TextView name, description, change;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.info_error_dialog, container, false);

        name = v.findViewById(R.id.error_name);
        description = v.findViewById(R.id.description);
        change = v.findViewById(R.id.change_btn);

        initInfo(this.log);

        change.setOnClickListener(l->{
            //todo тут код на исправление будет
        });

        return v;
    }

    public void initInfo(LogDataBase log) {
        name.setText(log.getAction());
        description.setText(log.getStatusText());
        change.setVisibility(log.isFixStatus()? View.GONE : View.VISIBLE);
    }
}
