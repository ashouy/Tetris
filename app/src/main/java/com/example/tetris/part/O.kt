package com.example.tetris.part

class O(x: Int = 1, y: Int = 5): Part(x, y) {

    init {

        dot1 = Dot(x,y)
        dot2 = Dot(x,(y+1))
        dot3 = Dot((x-1),(y+1))
        dot4 = Dot((x-1),y)
    }

    override fun down() {
        dot1.x +=1
        dot2.x +=1
        dot3.x +=1
        dot4.x +=1
    }

    override fun left() {
    }

    override fun right() {
    }

    override fun rotate() {
    }
}