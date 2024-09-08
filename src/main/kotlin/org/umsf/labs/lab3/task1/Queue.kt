package org.umsf.labs.lab3.task1

internal class Queue {

    private var head = 0
    private var tail = 0
    private var queue = Array<Int?>(10) { null }

    public fun add(element: Int) {
        if (tail + 1 >= queue.size) resize()
        queue[tail] = element
        tail++
    }

    private fun resize() {
        val newQueue = Array<Int?>((tail - head) * 2 + 10) { null }
        for (i in head..tail) {
            newQueue[i - head] = queue[i]
        }
        tail -= head
        head = 0
        queue = newQueue
    }

    public fun addAll(sequence: Iterable<Int>) {
        sequence.forEach(::add)
    }

    public fun poll(): Int {
        check(!isEmpty()) { "Queue is empty." }
        head++
        return queue[head - 1]!!
    }

    public fun isEmpty(): Boolean = head == tail

    public fun clear() {
        head = 0
        tail = 0
        queue = Array(10) { null }
    }

    public fun order() {
        val odd = Queue()
        val even = Queue()
        for (i in head..<tail) {
            if (queue[i]!! % 2 == 0) {
                even.add(queue[i]!!)
            } else {
                odd.add(queue[i]!!)
            }
        }
        clear()
        while (!odd.isEmpty()) {
            add(odd.poll())
        }
        while (!even.isEmpty()) {
            add(even.poll())
        }
    }

    override fun toString(): String = queue.toList()
        .subList(head, tail)
        .toString()
}
