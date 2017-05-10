package com.constantine.silver.mentalarithmetic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_classic_mode.*

class ClassicMode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classic_mode)
        println("ClassicMode создан")
        main_text.text = intent.getStringExtra("PARAM_TEXT")
        button2.setOnClickListener { super.onBackPressed() }
    }

    override fun onDestroy() {
        println("ClassicMode уничтожен")
        super.onDestroy()
    }
}