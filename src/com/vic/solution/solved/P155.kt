package com.vic.solution.solved

import com.vic.solution.ListNode
import java.util.*

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 示例:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 提示：
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P155 {

    class MinStack1 {
        /** initialize your data structure here. */
        private val stack = LinkedList<ListNode>()
        private val head = ListNode(-1)

        fun push(x: Int) {
            val node = ListNode(x)
            stack.push(node)

            if (head.next == null) {
                // 首节点，直接插入
                head.next = node
            } else {
                // 非首节点
                var p = head.next
                var pre = head
                while (p != null && p.`val` < x) {
                    pre = p
                    p = p.next
                }

                pre.next = node
                node.next = p
            }
        }

        fun pop() {
            val node = stack.pop()
            var p = head.next
            var pre = head
            while (p?.next != null && p != node) {
                pre = p
                p = p.next
            }

            pre.next = node.next
            node.next = null
        }

        fun top(): Int {
            return stack.peek().`val`
        }

        fun getMin(): Int {
            return head.next?.`val` ?: 0
        }
    }

    class MinStack2 {
        /** initialize your data structure here. */
        private val stack = LinkedList<Int>()
        private var minValue = Int.MAX_VALUE

        fun push(x: Int) {
            if (x < minValue) {
                minValue = x
            }

            stack.push(x)
        }

        fun pop() {
            val x = stack.pop()
            if (x == minValue) {
                minValue = Int.MAX_VALUE
                stack.forEach {
                    if (it < minValue) {
                        minValue = it
                    }
                }
            }
        }

        fun top(): Int {
            return stack.peek()
        }

        fun getMin(): Int {
            return minValue
        }
    }
}