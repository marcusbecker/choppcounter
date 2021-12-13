package br.com.mbecker.choppcount.bu

class ChoppCounter {

    private var counter = 0

    fun incCounter() {
        ++counter
    }

    fun resetCounter() {
        counter = 0
    }

    override fun toString(): String {
        return counter.toString()
    }

    fun get(): Int {
        return counter
    }

    fun set(c: Int) {
        counter = c
    }
}