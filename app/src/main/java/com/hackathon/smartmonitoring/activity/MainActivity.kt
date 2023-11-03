package com.hackathon.smartmonitoring.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hackathon.smartmonitoring.R
import com.hackathon.smartmonitoring.databinding.ActivityMainBinding
import com.hackathon.smartmonitoring.fragments.AllDataBaseFragment
import com.hackathon.smartmonitoring.fragments.CurrentDataBaseFragment
import com.hackathon.smartmonitoring.fragments.ProfFragment


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val fragment: Fragment? =  when(item.itemId) {
                R.id.item_1 -> {
                    AllDataBaseFragment()
                }
                R.id.item_2 -> {
                    CurrentDataBaseFragment()
                }
                R.id.item_3 -> {
                    ProfFragment()
                }
                else -> null
            }
            fragment?.let {
                supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(
                        R.anim.slide_in_from_top,
                        R.anim.slide_out_to_top,
                        R.anim.slide_in_from_top,
                        R.anim.slide_out_to_top
                    )
                    .replace(R.id.fragment_containe, it)
                    .commit()
            }
            true
        }

        binding.bottomNavigation.selectedItemId = R.id.item_1
    }

}