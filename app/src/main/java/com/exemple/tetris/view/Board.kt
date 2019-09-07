package com.exemple.tetris.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageView
import androidx.lifecycle.ViewModelProviders
import com.example.tetris.R
import com.game.Game

class Board : AppCompatActivity() {

    val game = ViewModelProviders.of(this)[Game::class.java]


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)



        val view = layoutInflater.inflate(R.layout.activity_board,null)

        val board = findViewById<GridLayout>(R.id.board)

        val gray = R.drawable.gray




    }
}
