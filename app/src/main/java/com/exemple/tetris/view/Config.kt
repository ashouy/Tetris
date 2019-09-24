package com.exemple.tetris.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tetris.R
import kotlinx.android.synthetic.main.activity_config.*

class Config : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        backConfig.setOnClickListener {
            var i = Intent(this,MenuActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}
