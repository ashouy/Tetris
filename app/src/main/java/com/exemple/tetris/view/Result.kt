package com.exemple.tetris.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tetris.R
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {

    val PREFS = "prefs_file2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var settings = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        var editor = settings.edit()

        if (settings.getInt("RECORD",0) < intent.extras!!.getInt("SCORE")){
            newRecord.visibility = View.VISIBLE
            editor.putInt("RECORD",intent.extras!!.getInt("SCORE"))
            editor.commit()
        }
        recordText.text = settings.getInt("RECORD",0).toString()
        scoreText.text = intent.extras!!.getInt("SCORE").toString()


            newGameResult.setOnClickListener {
                var b = Bundle()
                b.putInt("DIFICULT", intent.extras!!.getInt("DIFICULT"))
                var i = Intent(this,BoardActivity::class.java)
                i.putExtras(b)
                startActivity(i)
                finish()

            }
            sair.setOnClickListener {
                finish()
            }
    }
}
