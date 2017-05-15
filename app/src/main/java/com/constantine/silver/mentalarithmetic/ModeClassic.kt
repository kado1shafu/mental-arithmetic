package com.constantine.silver.mentalarithmetic

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.constantine.silver.mentalarithmetic.libs.ProgressGenerator
import com.dd.processbutton.iml.ActionProcessButton
import kotlinx.android.synthetic.main.activity_mode_classic.*
import com.roughike.swipeselector.SwipeItem
import android.widget.Toast
import com.constantine.silver.mentalarithmetic.libs.CircularAnim
import org.jetbrains.anko.contentView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class ModeClassic : AppCompatActivity(), ProgressGenerator.OnCompleteListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode_classic)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        setProgress()
        setSwitches()
        btnRun.setOnClickListener { ProgressGenerator(this).start(btnRun) }

    }

    override fun onComplete() {
        toast("GO!")
        CircularAnim.fullActivity(this@ModeClassic, contentView)
                .colorOrImageRes(R.color.blue_normal)
                .go { startActivity<MainActivity>() }
    }

    fun setProgress(){
        var currentProgress:Int = 124
        var maxProgress:Int = 200
        progressStateInt.text = "$currentProgress/$maxProgress"
        var progress: Double = currentProgress  * 100.0 / maxProgress
        progressStatePercent.text = "${progress.toInt()}%"
        progressLevel.setProgress(progress.toInt())
    }
    fun setSwitches(){

        swipeRange.setItems(
                SwipeItem(0, "Slide one", "Description for slide one."),
                SwipeItem(1, "Slide two", "Description for slide two."),
                SwipeItem(2, "Slide three", "Description for slide three.")
        )
        swipeOperations.setItems(
                SwipeItem(0, "Pref one", "Description for pref one."),
                SwipeItem(1, "Pref two", "Description for pref two."),
                SwipeItem(2, "Pref three", "Description for pref three.")
        )
        swipeOperations.setOnItemSelectedListener { when(it.value){
            0 -> mathExpression.text = "A ☆ B"
            1 -> mathExpression.text = "A ☆ B ☆ C"
            2 -> mathExpression.text = "A ☆ B ☆ C ☆ D"
        } }
        swipeOperations.selectItemAt(1)
        swipeRange.selectItemAt(1)
    }
}
