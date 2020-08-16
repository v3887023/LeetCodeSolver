package com.vic.solution.unsolved

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

        var tail: ListNode? = null

        var pre: ListNode? = null
        var p = head
        repeat(k) {
            if (p == null) {
                p = head
                if (tail == null) {
                    tail = pre
                }
            }

            pre = p
            p = p?.next
        }

        if (p == null) {
            return head
        }

        if (tail == null) {
            pre = p
            var q = p
            while (q != null) {
                pre = q
                q = q.next
            }

            tail = pre
        }

        val newHead: ListNode?
        if (p!!.next == null) {
            newHead = head.next
            head.next = null
        } else {
            newHead = p?.next
        }

        p?.next = null

        tail?.next = head

        return newHead
    }
}

fun main() {
    val newList = ListNode.newList(1)
    println(newList)
    println(P61().rotateRight(newList, 1) ?: "[]")
}