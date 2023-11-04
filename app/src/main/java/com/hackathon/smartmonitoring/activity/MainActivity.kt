package com.hackathon.smartmonitoring.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.hackathon.smartmonitoring.R
import com.hackathon.smartmonitoring.databinding.ActivityMainBinding
import com.hackathon.smartmonitoring.fragments.AllDataBaseFragment
import com.hackathon.smartmonitoring.fragments.CheckingFragment
import com.hackathon.smartmonitoring.fragments.CurrentDataBaseFragment
import com.hackathon.smartmonitoring.fragments.LoginFragment
import com.hackathon.smartmonitoring.fragments.ProfFragment
import com.hackathon.smartmonitoring.objects.TokenStorage
import com.hackathon.smartmonitoring.util.NotificationUtil
import com.hackathon.smartmonitoring.util.SharedPref
import com.hackathon.smartmonitoring.util.SignalRUtil
import com.hackathon.smartmonitoring.util.SignalRUtil.AddListener
import com.hackathon.smartmonitoring.util.SnackBarUtil


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    private lateinit var signalRManager: SignalRUtil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        if(!SharedPref.getAuthUser()){
//            replaceFragment(LoginFragment.newInstance(), true)
//        }

        NotificationUtil.createNotificationChannel(this)

        loadToken()
        initNavBar()

        signalRManager = SignalRUtil("https://newestsm.kaboom.pro/hubs/logs")
        signalRManager.startConnection()
        signalRManager.addOnAddListener(AddListener {
            runOnUiThread {
                print(it)
                handlerWebSocketMessage(it.description)
                NotificationUtil.showNotification(this, it.toString() , "it.description")
            }
        })
        
}

    override fun onDestroy() {
        super.onDestroy()
        signalRManager.stopConnection()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }




    private fun handlerWebSocketMessage(text: String) {
//        val util = SnackBarUtil.make(this.findViewById<View>(R.id.fragment_containe))
//            .setMessageWhenEnd(text)
//        val snackBarView = util.view
//        snackBarView.setBackgroundColor(Color.TRANSPARENT)
//        util.show()

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

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

            //startActivity(Intent(this, LoginActivity::class.java))
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

    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_containe, fragment, fragment.javaClass.simpleName)
        if (addToBackStack) fragmentTransaction.addToBackStack(fragment.javaClass.name)
        fragmentTransaction.commit()
    }
}