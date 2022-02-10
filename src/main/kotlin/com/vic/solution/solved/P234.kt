package com.vic.solution.solved

import com.vic.solution.common.ListNode

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 【示例 1】
 * 输入: 1->2
 * 输出: false
 *
 * 【示例 2】
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 【进阶】
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P234 {
    fun isPalindrome(head: ListNode?): Boolean {
        var fast = head
        var slow = head
        var pre: ListNode? = null

        while (fast != null) {
            fast = fast.next
            if (fast == null) {
                break
            }

            fast = fast.next
            pre = slow
            slow = slow!!.next
        }

        if (pre != null) {
            pre.next = null
            val reversedList = slow.reverse()

            var p1 = head
            var p2 = reversedList
            while (p1 != null) {
                if (p1.`val` != p2!!.`val`) {
                    return false
                }

                p1 = p1.next
                p2 = p2.next
            }

            pre.next = reversedList.reverse()
        }

        return true
    }

    private fun ListNode?.reverse(): ListNode? {
        val newHead = ListNode(-1)

        var p = this
        while (p != null) {
            val node = p
            p = p.next
            node.next = newHead.next
            newHead.next = node

        }

        return newHead.next
    }
}