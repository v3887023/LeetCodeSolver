package com.vic.solution.solved

import com.vic.solution.ListNode

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 【示例】
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P24 {
    fun swapPairs(head: ListNode?): ListNode? {
        val fakeHead = ListNode(-1)
        fakeHead.next = head

        var first: ListNode?
        var second: ListNode?
        var p: ListNode? = fakeHead
        while (p != null) {
            first = p.next
            second = first?.next

            if (first == null || second == null) {
                break
            }

            p.next = second
            first.next = second.next
            second.next = first

            p = first
        }

        val newHead = fakeHead.next
        fakeHead.next = null

        return newHead
    }
}