package com.exemple.tetris.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView
import androidx.lifecycle.ViewModelProviders
import com.example.tetris.R
import com.example.tetris.part.*
import com.game.Game
import kotlinx.android.synthetic.main.activity_board.*
import kotlin.random.Random

class BoardActivity : AppCompatActivity() {


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
            while(game.running){
                Thread.sleep(game.level[2])
                runOnUiThread{

                    for (i in 0 until game.LINHA) {
                        for (j in 0 until game.COLUNA) {
                            if(game.board[i][j] == 0) {
                                game.boardView[i][j]!!.setImageResource(R.drawable.ciano)
                            }else{
                                game.boardView[i][j]!!.setImageResource(R.drawable.gray)
                            }
                        }
                    }



                    btRotate.setOnClickListener {
                        o.rotate()
                    }
                    btLeft.setOnClickListener {
                        o.left()
                    }

                    btRight.setOnClickListener {
                        o.right()
                    }

                    try {
                        game.boardView[o.dot1.x][o.dot1.y]!!.setImageResource(R.drawable.gray)
                        game.boardView[o.dot2.x][o.dot2.y]!!.setImageResource(R.drawable.gray)
                        game.boardView[o.dot3.x][o.dot3.y]!!.setImageResource(R.drawable.gray)
                        game.boardView[o.dot4.x][o.dot4.y]!!.setImageResource(R.drawable.gray)
                    } catch (e: ArrayIndexOutOfBoundsException) {
                        game.running = false
                    }
                }


            }
        }.start()
    }

    private fun updateBoard(obj: Part){
        game.board[obj.dot1.x][obj.dot1.y] = 1
        game.board[obj.dot2.x][obj.dot2.y] = 1
        game.board[obj.dot3.x][obj.dot3.y] = 1
        game.board[obj.dot4.x][obj.dot4.y] = 1
    }
    private fun colision(obj : Part):Boolean{

    }
    private fun baseBoardColision(obj: Part):Boolean{
        return obj.dot1.x == 22 || obj.dot2.x == 22 || obj.dot3.x == 22 || obj.dot4.x == 22
    }

    private fun rightBoardColision(obj : Part):Boolean{
        return obj.dot1.y == 12 || obj.dot2.y == 12 || obj.dot3.y == 12 || obj.dot4.y == 12
    }

    private fun leftBoardColision(obj : Part):Boolean{
        return obj.dot1.y == 0 || obj.dot2.y == 0 || obj.dot3.y == 0 || obj.dot4.y == 0

    }

    private fun newPart(): Part {
        var p = Random.nextInt(0,5)

        when(p){
            0->{
                var i = I()
                return i
            }
            1->{
                var j = J()
                return j
            }
            2->{
                var l = L()
                return l
            }
            3->{
                var o = O()
                return o
            }
            4->{
                var s = S()
                return s
            }
            5->{
                var t = T()
                return t
            }
            else ->{
                var z = Z()
                return z
            }
        }
    }

    }
    private fun startPart():Part{

        var p = Random.nextInt(0,5)

        when(p){
            0->{
               var i = I()
                return i
            }
            1->{
                var j = J()
                return j
            }
            2->{
                var l = L()
                return l
            }
            3->{
                var o = O()
                return o
            }
            4->{
                var s = S()
                return s
            }
            5->{
                var t = T()
                return t
            }
            else ->{
                var z = Z()
                return z
            }
        }
    }


}
