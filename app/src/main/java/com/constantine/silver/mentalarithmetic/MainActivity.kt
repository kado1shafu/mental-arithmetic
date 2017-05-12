package com.constantine.silver.mentalarithmetic

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.constantine.silver.mentalarithmetic.R.id.*
import com.constantine.silver.mentalarithmetic.R.string.navigation_drawer_close
import com.constantine.silver.mentalarithmetic.R.string.navigation_drawer_open
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        println("Main создан")
        classic_mode.setOnClickListener { startActivity<ModeClassic>("PARAM_TEXT" to "start!") }
        button_exit.setOnClickListener { super.onBackPressed() }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, navigation_drawer_open, navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onDestroy() {
        println("Main уничтожен")
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START))
            drawer_layout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            nav_camera -> {}
            nav_gallery -> consume {  }
            nav_slideshow -> consume {  }
            nav_manage -> consume {  }
            nav_share -> consume {  }
            nav_send -> consume {  }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
