package com.hackathon.smartmonitoring.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.hackathon.smartmonitoring.R;
import com.hackathon.smartmonitoring.activity.MainActivity;
import com.hackathon.smartmonitoring.presenter.LoginPresenter;
import com.hackathon.smartmonitoring.util.SharedPref;
import com.hackathon.smartmonitoring.util.SnackBarUtil;
import com.hackathon.smartmonitoring.view.LoginView;

import butterknife.BindView;

public class LoginFragment extends BaseFragment implements LoginView {
    @BindView(R.id.login) EditText login;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.start) Button btn;
    public LoginPresenter presenter;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }
    @Override
    protected void initViews() {
        super.initViews();
        presenter = new LoginPresenter(this);

        btn.setOnClickListener(l->{
            if(!login.getText().toString().equals("") && !password.getText().toString().equals("")){
                presenter.loginPerson(login.getText().toString(), password.getText().toString());
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.login_fragment;
    }

    @Override
    public void successMessage(String msg) {
        SharedPref.setAuthUser(true);
        startActivity(new Intent(getActivity(), MainActivity.class));
    }

    @Override
    public void errorMessage(String msg) {
        SnackBarUtil util = SnackBarUtil.make(getActivity().findViewById(R.id.container))
                .setMessage(msg);
        View snackBarView = util.getView();
        snackBarView.setBackgroundColor(Color.TRANSPARENT);
        util.show();
    }
}