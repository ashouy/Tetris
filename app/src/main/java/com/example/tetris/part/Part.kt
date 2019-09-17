package com.example.tetris.part

abstract class Part( var x:Int, var y:Int){


    var dot1 = Dot(x,y)
    lateinit var dot2 :Dot
    lateinit var dot3 :Dot
    lateinit var dot4 :Dot
    var state = false

    abstract fun down()

    abstract fun left()

    abstract fun right()

    abstract fun rotate()
}