package com.vic.solution.solved

import com.vic.solution.ListNode

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 【示例】
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P21 {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode(-1)
        var p1 = l1
        var p2 = l2
        var p = head

        while (p1 != null && p2 != null) {
            if (p1.`val` < p2.`val`) {
                p.next = p1
                p1 = p1.next
            } else {
                p.next = p2
                p2 = p2.next
            }
            p = p.next!!
        }

        if (p1 == null) {
            p.next = p2
        } else if (p2 == null) {
            p.next = p1
        }

        return head.next
    }
}