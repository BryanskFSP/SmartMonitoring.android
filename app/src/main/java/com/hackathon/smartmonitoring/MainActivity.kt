package com.hackathon.smartmonitoring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hackathon.smartmonitoring.databinding.ActivityMainBinding
import com.hackathon.smartmonitoring.databinding.AllDatabaseFragmentBinding
import com.hackathon.smartmonitoring.fragments.AllDataBaseFragment

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_containe, AllDataBaseFragment())
            .commit()
    }

}