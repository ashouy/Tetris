package com.game

import android.widget.ImageView
import androidx.lifecycle.ViewModel


class Game(val LINHA: Int = 22,val COLUNA: Int = 12 ) : ViewModel(){
    var level = longArrayOf(450, 300, 150)

    var running = false

    var board = Array(LINHA) {
        Array(COLUNA){0}
    }

    var boardView = Array(LINHA){
        arrayOfNulls<ImageView>(COLUNA)
    }
    var score :Int = 0

    fun incrementScore(){
        score += 10
    }

    fun closeGame() {
    }

    fun resumeGame() {
    }

    fun pauseGame(){

    }

    fun configGame() {
    }
}

