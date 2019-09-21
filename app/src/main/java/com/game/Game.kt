package com.game

import android.widget.ImageView


class Game(val LINHA: Int = 22,val COLUNA: Int = 12 ) {
    var level = longArrayOf(150, 300, 450)

    var running = true
    var board = Array(LINHA) {
        Array(COLUNA){0}
    }

    var boardView = Array(LINHA){
        arrayOfNulls<ImageView>(COLUNA)
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

