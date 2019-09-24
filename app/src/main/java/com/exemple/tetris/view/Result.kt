package com.exemple.tetris.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tetris.R
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
            newGameResult.setOnClickListener {
                var i = Intent(this,BoardActivity::class.java)
                startActivity(i)
                finish()
            }
            sair.setOnClickListener {
                finish()
            }
    }
}
