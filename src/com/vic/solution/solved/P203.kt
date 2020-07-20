package com.vic.solution.solved

import com.vic.solution.ListNode

/**
 * 203. 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 【示例】
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P203 {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val newHead = ListNode(-1)
        newHead.next = head
        var pre = newHead
        var p = head

        while (p != null) {
            if (p.`val` == `val`) {
                pre.next = p.next
            } else {
                pre = p
            }
            p = p.next
        }

        return newHead.next
    }
}