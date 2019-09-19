package com.exemple.tetris.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.widget.GridLayout
import android.widget.ImageView
import androidx.lifecycle.ViewModelProviders
import com.example.tetris.R
import com.example.tetris.part.I
import com.example.tetris.part.J
import com.example.tetris.part.L
import com.example.tetris.part.Part
import com.game.Game
import kotlinx.android.synthetic.main.activity_board.*

class BoardActivity : AppCompatActivity() {



    var running:Boolean=(true)

    var j = J()
    var l = L()

    var game = Game()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)

        gridboard.rowCount = game.LINHA
        gridboard.columnCount = game.COLUNA

        val inflater = LayoutInflater.from(this)

        for( i in 0 until game.LINHA){
            for(j in 0 until game.COLUNA){
                game.boardView[i][j] = inflater.inflate(R.layout.block,gridboard,false) as ImageView
                gridboard.addView(game.boardView[i][j])
            }
        }


        gameRun()

    }

    private fun gameRun() {
        Thread{
            while(running){
                Thread.sleep(game.level[2])
                runOnUiThread{
                    for (i in 0 until game.LINHA){
                        for(j in 0 until game.COLUNA){
                            game.boardView[i][j]!!.setImageResource(R.drawable.ciano)
                        }
                    }
                    l.down()

                    try{
                        game.boardView[l.dot1.x][l.dot1.y]!!.setImageResource(R.drawable.gray)
                        game.boardView[l.dot2.x][l.dot2.y]!!.setImageResource(R.drawable.gray)
                        game.boardView[l.dot3.x][l.dot3.y]!!.setImageResource(R.drawable.gray)
                        game.boardView[l.dot4.x][l.dot4.y]!!.setImageResource(R.drawable.gray)
                    }catch (e:ArrayIndexOutOfBoundsException){
                        running = false
                    }
                }
            }
        }.start()
    }


}
