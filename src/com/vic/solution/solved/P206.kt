package com.vic.solution.solved

import com.vic.solution.ListNode

/**
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 【示例】
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 【进阶】
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P206 {
    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        val second = head.next!!
        val newHead = reverseList(second)
        second.next = head
        head.next = null

        return newHead
    }

    fun reverseList2(head: ListNode?): ListNode? {
        val newHead = ListNode(-1)
        var p = head
        while (p != null) {
            val next = p.next

            p.next = newHead.next
            newHead.next = p

            p = next
        }

        return newHead.next
    }
}