package com.vic.solution.solved

import com.vic.solution.ListNode

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 【示例】
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 【说明】
 * 给定的 n 保证是有效的。
 *
 * 【进阶】
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var fast = head
        var slow = head

        var i = 0
        while (i < n) {
            fast = fast?.next
            i++
        }

        if (fast == null) {
            return head?.next
        }

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next
        }

        slow?.next = slow?.next?.next

        return head
    }
}