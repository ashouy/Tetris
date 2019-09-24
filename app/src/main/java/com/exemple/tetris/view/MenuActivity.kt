package com.exemple.tetris.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tetris.R
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
  //  var pref = getPreferences(Context.MODE_PRIVATE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        newGame.setOnClickListener {
            var i = Intent(this,BoardActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}
