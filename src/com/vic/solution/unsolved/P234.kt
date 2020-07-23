package com.vic.solution.unsolved

import com.vic.solution.ListNode

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
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P234 {
    class Solution {
        fun isPalindrome(head: ListNode?): Boolean {
            val length = head.length()
            if (length < 2) {
                return true
            }



            return false
        }

        private fun ListNode?.length(): Int {
            var length = 0
            var p = this
            while (p != null) {
                length++
                p = p.next
            }

            return length
        }
    }
}