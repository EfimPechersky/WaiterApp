package com.example.notifyapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView

class MyReceiverTime(textv: TextView) : BroadcastReceiver() {
    var txt=textv
    var time=0
    override fun onReceive(context: Context, intent: Intent) {
        time+=1
        txt.text = "время созерцания "+time.toString()+" минут"
    }
}
class MyReceiverBattery(textv: TextView) : BroadcastReceiver() {
    var txt=textv
    override fun onReceive(context: Context, intent: Intent) {
        txt.text = "накормите Ждуна,силы на исходе!"
    }
}