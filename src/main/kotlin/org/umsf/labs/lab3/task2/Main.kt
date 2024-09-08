package org.umsf.labs.lab3.task2

import java.io.File
import java.io.PrintWriter

public fun main() {
    val stack = Stack()
    val url = Stack::class.java.getResource("/task2.txt")
    checkNotNull(url)
    val file = File(url.toURI())
    file.readLines().forEach { stack.push(it) }
    val result = StringBuilder()
    while (!stack.isEmpty()) {
        val element = stack.pop()
        result.append(element).appendLine()
        println(element)
    }
    file.writeText(result.toString())
}
