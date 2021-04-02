package com.vic.solution.solved

import com.vic.solution.common.ListNode

/**
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P86 {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val fakeHead = ListNode(-1)
        fakeHead.next = head

        var pre = fakeHead
        var p = head
        var theNode: ListNode? = null
        var theNodePre: ListNode? = null
        while (p != null) {
            val next = p.next

            if (p.`val` < x) {
                if (theNode != null) {
                    pre.next = next
                    p.next = theNode
                    theNodePre!!.next = p
                    theNodePre = p
                    p = next
                    continue
                }
            } else {
                if (theNode == null) {
                    theNode = p
                    theNodePre = pre
                }
            }

            pre = p
            p = next
        }

        val newHead = fakeHead.next
        fakeHead.next = null

        return newHead
    }
}