package com.example.myapplication1

import MyLifecycleObserver
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activity_B : AppCompatActivity() ,View.OnClickListener{
    private val tag = "Activity_B"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        // 获取相应组件 val不可变
        val startA: Button = findViewById(R.id.BStart_A)
        val startC: Button = findViewById(R.id.BStart_C)
        val finishB: Button = findViewById(R.id.BFinish_B)
        val dialog: Button = findViewById(R.id.BDialog)

        startA.setOnClickListener(this)
        startC.setOnClickListener(this)
        finishB.setOnClickListener(this)
        dialog.setOnClickListener(this)

        //感知生命周期
        lifecycle.addObserver(
            MyLifecycleObserver(
                "Activity B",
                findViewById(R.id.mlist_b),
                findViewById(R.id.status_b),
            ))

    }

    // Java中采用switch(); Kotlin中采用when()
    override fun onClick(p0: View?){
        when(p0?.id){
            R.id.BStart_A -> {
                // startB 按钮被点击时，创建一个 Intent 对象
                val intent = Intent(this, Activity_A::class.java)
                // 然后使用该 Intent 启动 ActivityB 实现页面导航
                startActivity(intent)
            }
            R.id.BStart_C -> {
                val intent = Intent(this, Activity_C::class.java)
                startActivity(intent)
            }
            R.id.BFinish_B -> {
                // 退回上一步操作
                finish()
            }
            R.id.BDialog -> {
                val intent = Intent(this, DialogActivity::class.java)
                startActivity(intent)
            }
        }
    }

    // 测试
    override fun onStart() {
        super.onStart()
        // 在Activity即将可见时调用
        Log.d(tag, "Activty B onStart")
        // 添加自定义逻辑
    }

    override fun onResume() {
        super.onResume()
        // 在Activity获得焦点并可与用户进行交互时调用
        Log.d(tag, "Activty B onResume")
        // 添加自定义逻辑
    }

    override fun onPause() {
        super.onPause()
        // 在Activity失去焦点但仍可见时调用
        Log.d(tag, "Activty B onPause")
        // 添加自定义逻辑
    }

    override fun onStop() {
        super.onStop()
        // 在Activity不再可见时调用
        Log.d(tag, "Activty B onStop")
        // 添加自定义逻辑
    }

    override fun onDestroy() {
        super.onDestroy()
        // 在Activity被销毁之前调用
        Log.d(tag, "Activty B onDestroy")
        // 添加自定义逻辑
    }
}