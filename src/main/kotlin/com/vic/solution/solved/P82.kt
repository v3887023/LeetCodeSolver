package com.vic.solution.solved

import com.vic.solution.common.ListNode

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 【示例  1】
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 * 【示例  2】
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P82 {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        val fakeHead = ListNode(-1)
        fakeHead.next = head

        // 当遇到重复的元素时，last 保存的是该重复元素中第一个元素的前一个结点
        var last: ListNode = fakeHead
        var pre: ListNode = head

        var p = head.next
        while (p != null) {
            if (last.next!!.`val` != p.`val`) {
                if (last.next != pre) {
                    pre.next = null
                    last.next = p
                } else {
                    last = pre
                }
            }

            pre = p
            p = p.next
        }

        if (last.next != pre) {
            last.next = null
        }

        val newHead = fakeHead.next
        fakeHead.next = null

        return newHead
    }
}