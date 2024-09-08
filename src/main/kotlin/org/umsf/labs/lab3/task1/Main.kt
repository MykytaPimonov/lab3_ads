package org.umsf.labs.lab3.task1

public fun main() {
    val queue = Queue()
    println("Enter queue:")
    val sequence = readln().trim().split(" ")
        .map { it.toInt() }
    queue.addAll(sequence)
    println("Current queue: $queue.")
    queue.order()
    println("Ordered queue: $queue.")
}
