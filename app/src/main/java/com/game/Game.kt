package com.game

import android.widget.ImageView


class Game(val LINHA: Int = 22,val COLUNA: Int = 12 ) {
    var level: Long = 300

    var board = Array(LINHA) {
        Array(COLUNA){}
    }

    var boardView = Array(LINHA){
        arrayOfNulls<ImageView>(COLUNA)
    }


    fun startGame() {
    }

    fun closeGame() {
    }

    fun resumeGame() {
    }

    fun configGame() {
    }
}

