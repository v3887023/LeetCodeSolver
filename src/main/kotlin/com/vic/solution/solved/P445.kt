package com.vic.solution.solved

import com.vic.solution.common.ListNode
import java.util.*

/**
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 【进阶】
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 【示例】
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P445 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val stack1 = getStack(l1)
        val stack2 = getStack(l2)

        var carry = 0
        val fakedHead = ListNode(-1)
        while (stack1.isNotEmpty() && stack2.isNotEmpty()) {
            val sum = stack1.pop() + stack2.pop() + carry
            carry = sum / 10
            linkBefore(fakedHead, ListNode(sum % 10))
        }

        while (stack1.isNotEmpty()) {
            val sum = stack1.pop() + carry
            carry = sum / 10
            linkBefore(fakedHead, ListNode(sum % 10))
        }

        while (stack2.isNotEmpty()) {
            val sum = stack2.pop() + carry
            carry = sum / 10
            linkBefore(fakedHead, ListNode(sum % 10))
        }

        if (carry > 0) {
            linkBefore(fakedHead, ListNode(carry))
        }

        val head = fakedHead.next
        fakedHead.next = null

        return head
    }

    private fun linkBefore(head: ListNode, node: ListNode) {
        node.next = head.next
        head.next = node
    }

    private fun getStack(list: ListNode?): LinkedList<Int> {
        val stack = LinkedList<Int>()

        var p = list
        while (p != null) {
            stack.push(p.`val`)
            p = p.next
        }

        return stack
    }
}