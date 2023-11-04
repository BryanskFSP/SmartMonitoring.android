package com.hackathon.smartmonitoring.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.hackathon.smartmonitoring.R;
import com.hackathon.smartmonitoring.dialog.InfoErrorDialog;
import com.hackathon.smartmonitoring.dialog.SimpleInfoErrorDialog;
import com.hackathon.smartmonitoring.model.DataBaseModel;

public class SnackBarUtil extends BaseTransientBottomBar<SnackBarUtil> {
    private Context context;
    public SimpleInfoErrorDialog dialog;
    public DataBaseModel model = new DataBaseModel();

    public SnackBarUtil(@NonNull ViewGroup parent, @NonNull View content, @NonNull com.google.android.material.snackbar.ContentViewCallback contentViewCallback, Context context) {
        super(parent, content, contentViewCallback);
        this.context = context;
    }

    public static SnackBarUtil make(View view) {
        View customView = LayoutInflater.from(view.getContext()).inflate(R.layout.custom_snack_bar, null);
//        customView.setBackgroundResource(R.color.transpanent);

        SnackBarUtil snackBarUtil = new SnackBarUtil(
                (ViewGroup) view,
                customView,
                new ContentViewCallback() {
                    @Override
                    public void animateContentIn(int delay, int duration) {
                    }

                    @Override
                    public void animateContentOut(int delay, int duration) {
                    }
                },
                view.getContext()
        );
        return snackBarUtil;
    }
    public SnackBarUtil setMessageWhenEnd(String info) {
        TextView text = getView().findViewById(R.id.text);
        text.setText(info);

       // getView().findViewById(R.id.image).setVisibility(View.GONE);

        TextView correct = getView().findViewById(R.id.correct);
        correct.setOnClickListener(l->{
            model.killLogProccess(SharedPref.getIdDataBase());
        });
        return this;
    }
    public SnackBarUtil setMessage(String info, String name, boolean type) {
        TextView text = getView().findViewById(R.id.text);
        text.setText(info);
        TextView correct = getView().findViewById(R.id.correct);
        correct.setOnClickListener(l->{
            model.killLogProccess(SharedPref.getIdDataBase());
        });
        getView().setOnClickListener(l->{
            dialog = new SimpleInfoErrorDialog(name, info, type);
            dialog.setCancelable(true);
            dialog.show(dialog.getFragmentManager(), "lol");
        });
        return this;
    }
}
