package com.example.myapplication1

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DialogActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE) //去除这个Activity的标题栏
        setContentView(R.layout.simple_dialog)

        val close: Button = findViewById(R.id.close_button)
        close.setOnClickListener {
            finish()
        }
    }
}