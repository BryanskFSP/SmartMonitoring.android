package com.hackathon.smartmonitoring.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.hackathon.smartmonitoring.R;

public class SnackBarUtil extends BaseTransientBottomBar<SnackBarUtil> {
    private Context context;

    public SnackBarUtil(@NonNull ViewGroup parent, @NonNull View content, @NonNull com.google.android.material.snackbar.ContentViewCallback contentViewCallback, Context context) {
        super(parent, content, contentViewCallback);
        this.context = context;
    }

    public static SnackBarUtil make(View view) {
        View customView = LayoutInflater.from(view.getContext()).inflate(R.layout.custom_snack_bar, null);
        customView.setBackgroundResource(R.color.transpanent);

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

    public SnackBarUtil setMessage(String info) {
        TextView text = getView().findViewById(R.id.text);
        text.setText(info);
        TextView correct = getView().findViewById(R.id.correct);
        correct.setOnClickListener(l->{
            //тут обращаение к методу
        });
        getView().setOnClickListener(l->{
            //открытие bottomSheet
        });
        return this;
    }
}
