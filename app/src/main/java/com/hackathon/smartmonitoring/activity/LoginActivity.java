package com.hackathon.smartmonitoring.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.hackathon.smartmonitoring.R;
import com.hackathon.smartmonitoring.fragments.LoginFragment;
import com.hackathon.smartmonitoring.util.SharedPref;

public class LoginActivity extends BaseActivity {
    @Override
    protected void initViews(@Nullable Bundle saveInstanceState) {
        if(SharedPref.getAuthUser()){
            startActivity(new Intent(this, MainActivity.class));
        } else replaceFragment(LoginFragment.newInstance(), true);
    }

    @Override
    protected int layoutResId() {
        return R.layout.login_activity;
    }
    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }


    @Override
    protected int titleResId() {
        return 0;
    }
}
