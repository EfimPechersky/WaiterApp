package com.example.notifyapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity() {
    val intentFilterTime = IntentFilter("android.intent.action.TIME_TICK")
    val intentFilterBattery = IntentFilter("android.intent.action.BATTERY_LOW")
    lateinit var receiverTime: MyReceiverTime
    lateinit var receiverBattery:MyReceiverBattery
    lateinit var txt:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        txt = findViewById(R.id.print)
        receiverTime= MyReceiverTime(txt)
        receiverBattery = MyReceiverBattery(txt)
        registerReceiver(receiverTime, intentFilterTime)
        registerReceiver(receiverBattery, intentFilterBattery)
    }
    fun cancel_wait(view: View){
        unregisterReceiver(receiverTime)
        Toast.makeText(this, getString(R.string.toast_text), Toast.LENGTH_SHORT).show()
        txt.text = getString(R.string.text)
    }
}