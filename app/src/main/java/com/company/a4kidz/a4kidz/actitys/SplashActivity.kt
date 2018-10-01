package com.company.a4kidz.a4kidz.actitys

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.company.a4kidz.a4kidz.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)
        var backGround = object : Thread(){
            override fun run() {
                try{
                    Thread.sleep(3000)
                    val intent = Intent(baseContext, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }
        }
        backGround.start()

    }
}
