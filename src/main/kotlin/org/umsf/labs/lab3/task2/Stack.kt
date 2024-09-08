package org.umsf.labs.lab3.task2

import kotlin.math.max

public class Stack {
    private var stack = Array<String?>(10) { null }
    private var index = 0

    public fun push(element: String) {
        if (index + 1 >= stack.size) resize()
        stack[index++] = element
    }

    private fun resize() {
        val newStack = Array<String?>(index * 2 + 10) { null }
        for (i in 0..index) {
            newStack[i] = stack[i]
        }
        stack = newStack
    }

    public fun pop(): String {
        check(!isEmpty()) { "Stack is empty." }
        index--
        val result = stack[index]!!
        stack[index] = null
        return result
    }

    public fun isEmpty(): Boolean = index <= 0

    public fun clear() {
        stack = Array(10) { null }
        index = 0
    }

    override fun toString(): String = stack.toList()
        .subList(0, max(0, index))
        .toString()
}
