package com.vic.solution.solved

import com.vic.solution.ListNode

/**
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 【示例 1】
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 【示例 2】
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P61 {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 0) {
            return head
        }

        var slow = head
        var fast = head
        var tail: ListNode? = null
        var i = 0
        while (i < k) {
            if (fast == null) {
                i = k - k % i
                if (i == k) {
                    break
                }

                fast = head
                if (tail == null) {
                    tail = slow
                }
            }

            slow = fast
            fast = fast.next
            i++
        }

        if (fast == null) {
            return head
        }

        val lastFast = fast

        if (tail == null) {
            while (fast != null) {
                slow = fast
                fast = fast.next
            }
            tail = slow
        }

        var pre: ListNode = head
        slow = head
        fast = lastFast
        while (fast != null) {
            pre = slow!!
            slow = slow.next
            fast = fast.next
        }

        val newHead = pre.next
        tail!!.next = head
        pre.next = null

        return newHead
    }

    fun rotateRight2(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k == 0) {
            return head
        }

        var tail: ListNode = head
        var length = 1
        while (tail.next != null) {
            tail = tail.next!!
            length++
        }

        tail.next = head

        var p: ListNode = head
        repeat(length - k % length - 1) {
            p = p.next!!
        }

        val newHead = p.next
        p.next = null

        return newHead
    }
}