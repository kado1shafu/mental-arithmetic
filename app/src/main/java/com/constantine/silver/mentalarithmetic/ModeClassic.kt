package com.constantine.silver.mentalarithmetic

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mode_classic.*
import org.jetbrains.anko.relativeLayout
import org.jetbrains.anko.toast

class ModeClassic : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode_classic)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        switch_addition.setOnCheckedChangeListener { view, isChecked ->  }
        segmentedButtonGroup.setOnClickedButtonPosition { toast(it.toString())}
    }
}
