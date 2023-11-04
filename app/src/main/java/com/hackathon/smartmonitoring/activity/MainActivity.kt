package com.hackathon.smartmonitoring.activity

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.hackathon.smartmonitoring.R
import com.hackathon.smartmonitoring.databinding.ActivityMainBinding
import com.hackathon.smartmonitoring.fragments.AllDataBaseFragment
import com.hackathon.smartmonitoring.fragments.CurrentDataBaseFragment
import com.hackathon.smartmonitoring.fragments.LoginFragment
import com.hackathon.smartmonitoring.fragments.ProfFragment
import com.hackathon.smartmonitoring.objects.TokenStorage
import com.hackathon.smartmonitoring.util.SharedPref
import com.hackathon.smartmonitoring.util.SnackBarUtil
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    private var webSocket: WebSocket? = null
//    private val activity = MainActivity.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        loadToken()
        initNavBar()


    webSocket = OkHttpClient()
        .newWebSocket(Request.Builder().url("https://newestsm.kaboom.pro/jubs/logs").build(),  MyWebSocketListener())
    print( "КЕКЕКЕКЕКЕ")

    }


    inner class MyWebSocketListener : WebSocketListener() {
        override fun onOpen(webSocket: WebSocket, response: Response) {
            super.onOpen(webSocket, response)
            Log.d("WEB_SOCKET", response?.isSuccessful.toString())
            print(  response?.isSuccessful.toString())
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            super.onMessage(webSocket, text)
            handlerWebSocketMessage(text)
        }

        override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
            super.onMessage(webSocket, bytes)
            // Обработка бинарных сообщений от сервера
        }

        override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
            super.onClosing(webSocket, code, reason)
            // WebSocket закрывается
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            super.onFailure(webSocket, t, response)
            Log.e("WEB_SOCKET", "WebSocket failure: ${t.message}")
            print("WebSocket failure: ${t.message}")
        }

    }

    private fun handlerWebSocketMessage(text: String) {
        val util = SnackBarUtil.make(this.findViewById<View>(R.id.fragment_containe))
            .setMessage(text)
        val snackBarView = util.view
        snackBarView.setBackgroundColor(Color.TRANSPARENT)
        util.show()

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

    fun replaceFragment(fragment: Fragment, addToBackStack: Boolean) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_containe, fragment, fragment.javaClass.simpleName)
        if (addToBackStack) fragmentTransaction.addToBackStack(fragment.javaClass.name)
        fragmentTransaction.commit()
    }
}