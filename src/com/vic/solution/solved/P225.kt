package com.vic.solution.solved

import java.util.*

/**
 * 225. 用队列实现栈
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * 【注意】
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P225 {
    /** Initialize your data structure here. */
    private val queue: Queue<Int> = LinkedList()

    /** Push element x onto stack. */
    fun push(x: Int) {
        queue.offer(x)
        repeat(queue.size - 1) {
            queue.offer(queue.poll())
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    fun pop(): Int {
        return queue.poll()
    }

    /** Get the top element. */
    fun top(): Int {
        return queue.peek()
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
        return queue.isEmpty()
    }

    class MyStack1 {
        /** Initialize your data structure here. */
        private val queue2: Queue<Int> = LinkedList()
        private val queue1: Queue<Int> = LinkedList()

        /** Push element x onto stack. */
        fun push(x: Int) {
            if (queue2.isEmpty()) {
                queue1.offer(x)
            } else {
                queue2.offer(x)
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        fun pop(): Int {
            return if (queue2.isEmpty()) {
                pop(queue1, queue2)
            } else {
                pop(queue2, queue1)
            }
        }

        private fun pop(qa: Queue<Int>, qb: Queue<Int>): Int {
            while (qa.size > 1) {
                qb.offer(qa.poll())
            }

            return qa.poll()
        }

        /** Get the top element. */
        fun top(): Int {
            return if (queue2.isEmpty()) {
                top(queue1, queue2)
            } else {
                top(queue2, queue1)
            }
        }

        private fun top(qa: Queue<Int>, qb: Queue<Int>): Int {
            while (qa.size > 1) {
                qb.offer(qa.poll())
            }

            val top = qa.poll()
            qb.offer(top)

            return top
        }

        /** Returns whether the stack is empty. */
        fun empty(): Boolean {
            return queue1.isEmpty() && queue2.isEmpty()
        }
    }

    class MyStack2 {
        /** Initialize your data structure here. */
        private val queue: Queue<Int> = LinkedList()

        /** Push element x onto stack. */
        fun push(x: Int) {
            queue.offer(x)
        }

        /** Removes the element on top of the stack and returns that element. */
        fun pop(): Int {
            repeat(queue.size - 1) {
                queue.offer(queue.poll())
            }

            return queue.poll()
        }

        /** Get the top element. */
        fun top(): Int {
            repeat(queue.size - 1) {
                queue.offer(queue.poll())
            }

            val top = queue.poll()
            queue.offer(top)

            return top
        }

        /** Returns whether the stack is empty. */
        fun empty(): Boolean {
            return queue.isEmpty()
        }
    }
}