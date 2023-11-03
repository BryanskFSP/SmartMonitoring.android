package com.hackathon.smartmonitoring.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hackathon.smartmonitoring.R
import com.hackathon.smartmonitoring.databinding.ActivityMainBinding
import com.hackathon.smartmonitoring.fragments.AllDataBaseFragment
import com.hackathon.smartmonitoring.fragments.LoginFragment


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        AllDataBaseFragment.newInstance()?.let { replaceFragment(it, true) }
        
    }
    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean) {
        val fragmentTransaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_containe, fragment, fragment.javaClass.simpleName)
        if (addToBackStack) fragmentTransaction.addToBackStack(fragment.javaClass.name)
        fragmentTransaction.commit()
    }

}