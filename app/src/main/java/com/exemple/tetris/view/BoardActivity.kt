package com.exemple.tetris.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageView
import androidx.lifecycle.ViewModelProviders
import com.example.tetris.R
import com.example.tetris.part.I
import com.example.tetris.part.Part
import com.game.Game
import kotlinx.android.synthetic.main.activity_board.*

class BoardActivity : AppCompatActivity() {



    var running:Boolean=(true)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

    }
}
