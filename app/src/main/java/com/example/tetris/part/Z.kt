package com.example.tetris.part

class Z(x: Int, y: Int): Part(x, y) {

    init {
        dot1 = Dot(x,y)
        dot2 = Dot(x,(y+1))
        dot3 = Dot((x-1),y)
        dot4 = Dot((x-1),(y-1))
    }

    override fun down() {
        dot1.x +=1
        dot2.x +=1
        dot3.x +=1
        dot4.x +=1
    }

    override fun left() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun right() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun rotate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}