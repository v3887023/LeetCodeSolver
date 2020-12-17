package com.vic.solution.trying

import com.vic.solution.ListNode
import com.vic.solution.println

/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 【说明】
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 【示例】
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P92 {
    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        var i = 1
        val fakedHead = ListNode(-1)
        fakedHead.next = head
        var p: ListNode? = fakedHead
        var mNode: ListNode? = null
        var nNode: ListNode? = null
        var next: ListNode? = null
        var pre: ListNode? = null
        while (i <= n && p != null) {
            next = p.next
            if (i == m) {
                mNode = p
            }

            i++
            if (i < m) {
                pre = p
            }

            p = next
        }

        val newHead = fakedHead.next
        fakedHead.next = null

        return newHead
    }
}

fun main() {
//    P92().reverseBetween(ListNode.newList(1, 2, 3, 4, 5), 2, 4)?.println()

    Thread {
        repeat(5) {
            it.println()
            Thread.sleep(1000)
        }
    }.apply {
        isDaemon = false
    }.start()
}