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

    var p = newPart()
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
                runOnUiThread {


                            /*
                            redesenha o board
                             */
                            for (i in 0 until game.LINHA) {
                                for (j in 0 until game.COLUNA) {
                                    if (game.board[i][j] == 0) {
                                        game.boardView[i][j]!!.setImageResource(R.drawable.ciano)
                                    } else {
                                        game.boardView[i][j]!!.setImageResource(R.drawable.gray)
                                    }
                                }
                            }

                            btRotate.setOnClickListener {
                                p.rotate()
                            }

                            btLeft.setOnClickListener {
                                if(!leftBoardColision(p))
                                p.left()
                            }

                            btRight.setOnClickListener {
                                if(!rightBoardColision(p))
                                p.right()
                            }



                            if(!baseBoardColision(p) && !colision(p)){
                                p.down()
                            }else{
                                updateBoard(p)
                                p = newPart()
                            }

                            try {
                                game.boardView[p.dot1.x][p.dot1.y]!!.setImageResource(R.drawable.gray)
                                game.boardView[p.dot2.x][p.dot2.y]!!.setImageResource(R.drawable.gray)
                                game.boardView[p.dot3.x][p.dot3.y]!!.setImageResource(R.drawable.gray)
                                game.boardView[p.dot4.x][p.dot4.y]!!.setImageResource(R.drawable.gray)
                            } catch (e: ArrayIndexOutOfBoundsException) {
                                game.running = false
                            }

                }


            }
        }.start()
    }

    /*
    Marcar 1 no board nas coordenadas da peça
     */
    private fun updateBoard(obj: Part){
        game.board[obj.dot1.x][obj.dot1.y] = 1
        game.board[obj.dot2.x][obj.dot2.y] = 1
        game.board[obj.dot3.x][obj.dot3.y] = 1
        game.board[obj.dot4.x][obj.dot4.y] = 1
        }
    /*
    Retorna Verdadeiro caso um ponto da peça encoste em algum "1"
     */
    private fun colision(obj : Part):Boolean{

            return game.board[obj.dot1.x +1][obj.dot1.y] == 1 || game.board[obj.dot2.x +1][obj.dot2.y] == 1
                    || game.board[obj.dot3.x +1][obj.dot3.y] == 1 || game.board[obj.dot4.x +1][obj.dot4.y] == 1
    }
    /*
    retorna verdadeiro caso algum ponto da peça atinja a linha 22(última linha do board)
     */
    private fun baseBoardColision(obj: Part):Boolean{
        return obj.dot1.x == 21 || obj.dot2.x == 21 || obj.dot3.x == 21 || obj.dot4.x == 21
    }
    /*
    retorna verdadeiro caso algum ponto atinja a borda direita do board
     */
    private fun rightBoardColision(obj : Part):Boolean{
        return obj.dot1.y == 11 || obj.dot2.y == 11 || obj.dot3.y == 11 || obj.dot4.y == 11
    }
    /*
    retorna verdadeiro caso algum ponto atinja a borda esquerda do board
     */
    private fun leftBoardColision(obj : Part):Boolean{
        return obj.dot1.y == 0 || obj.dot2.y == 0 || obj.dot3.y == 0 || obj.dot4.y == 0

    }
    /*
    retorna uma nova peça aleatória
     */
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

    /*
        condiciona peça para rotação
     */
    private fun letRotation(){

    }

}
