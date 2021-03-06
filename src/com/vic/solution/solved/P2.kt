package com.vic.solution.solved

import com.vic.solution.common.ListNode

/**
 * 2.两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 【示例】
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val newHead = ListNode(-1)
        var p: ListNode = newHead
        var p1: ListNode? = l1
        var p2: ListNode? = l2
        var carry = 0
        while (p1 != null && p2 != null) {
            val n: Int = p1.`val` + p2.`val` + carry
            p.next = ListNode(n % 10)
            carry = n / 10
            p = p.next!!
            p1 = p1.next
            p2 = p2.next
        }
        while (p1 != null) {
            val n: Int = p1.`val` + carry
            p.next = ListNode(n % 10)
            carry = n / 10
            p = p.next!!
            p1 = p1.next
        }
        while (p2 != null) {
            val n: Int = p2.`val` + carry
            p.next = ListNode(n % 10)
            carry = n / 10
            p = p.next!!
            p2 = p2.next
        }
        if (carry > 0) {
            p.next = ListNode(carry)
        }
        return newHead.next
    }
}