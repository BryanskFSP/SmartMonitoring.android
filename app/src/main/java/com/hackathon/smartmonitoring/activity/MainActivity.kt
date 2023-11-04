package com.hackathon.smartmonitoring.activity

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import com.hackathon.smartmonitoring.R
import com.hackathon.smartmonitoring.databinding.ActivityMainBinding
import com.hackathon.smartmonitoring.fragments.*
import com.hackathon.smartmonitoring.objects.TokenStorage
import com.hackathon.smartmonitoring.util.SharedPref


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadToken()
        initNavBar()
    }

    private fun initNavBar() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            /*if(TokenStorage.token.isNullOrEmpty()) {
                openAuth()
                return@setOnItemSelectedListener true
            }*/

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
                R.id.item_4 -> {
                    CheckingFragment()
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

    private fun loadToken() {
        TokenStorage.token = SharedPref.getToken()
    }

    private fun openAuth() {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in_from_top,
                R.anim.slide_out_to_top,
                R.anim.slide_in_from_top,
                R.anim.slide_out_to_top
            )
            .replace(R.id.fragment_containe, LoginFragment.newInstance())
            .commit()
    }

}