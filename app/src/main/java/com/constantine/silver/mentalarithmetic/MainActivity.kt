package com.constantine.silver.mentalarithmetic

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.constantine.silver.mentalarithmetic.libs.CircularAnim
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.contentView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Main создан")
        circleMenu.setMainMenu(Color.RED, R.drawable.ic_go, R.drawable.ic_clear)
                .addSubMenu(Color.RED, R.drawable.ic_play_arrow)
                .addSubMenu(Color.BLUE, R.drawable.ic_favorite)
                .addSubMenu(Color.parseColor("#ffffff"), R.drawable.ic_favorite)
                .setOnMenuSelectedListener {
                    when(it){
                        0 -> delayStart{ circularAnim(R.color.red){ startActivity<ModeClassic>() } }
                        1 -> toast("1")
                        2 -> toast("2")
                    }
                }
    }

    override fun onDestroy() {
        println("Main уничтожен")
        super.onDestroy()
    }

    override fun onBackPressed() {
            super.onBackPressed()
    }

    fun circularAnim(color: Int, f: () -> Unit){
        CircularAnim.fullActivity(this@MainActivity, contentView)
                .colorOrImageRes(color)
                .go { f() }
    }
}

