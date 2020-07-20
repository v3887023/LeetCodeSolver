package com.vic.solution.solved

import com.vic.solution.ListNode

/**
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * （由于图无法显示，题目描述也简单易懂，所以就不贴示例了）
 *
 * 【注意】
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P160 {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null) {
            return null
        }

        // 用 p 找到链表 headA 的最后一个节点，由于前面已经过滤了 headA 为空的情况，所以 p 一定不为空
        var p = headA
        while (p!!.next != null) {
            p = p.next
        }

        p.next = headB

        var fast = headA
        var slow = headA
        while (fast != null) {
            fast = fast.next
            if (fast == null) {
                break
            }

            fast = fast.next
            slow = slow!!.next

            if (fast == slow) {
                break
            }
        }

        if (fast != null) {
            slow = headA
            while (slow != fast) {
                slow = slow!!.next
                fast = fast!!.next
            }
        }

        p.next = null

        return fast
    }
}