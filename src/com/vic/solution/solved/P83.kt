package com.vic.solution.solved

import com.vic.solution.common.ListNode

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P83 {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var p = head

        while (p != null) {
            val value = p.`val`
            var node = p.next
            while (node != null && node.`val` == value) {
                node = node.next
            }

            p.next = node
            p = node
        }

        return head
    }
}