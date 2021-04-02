package com.vic.solution.solved

import com.vic.solution.common.ListNode

/**
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 *
 * (动画演示)
 *
 * 【插入排序算法】
 *   1.插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 *   2.每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 *   3.重复直到所有输入数据插入完为止。
 *
 * 【示例 1】
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 【示例 2】
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P147 {
    fun insertionSortList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        val fakeHead = ListNode(-1)
        fakeHead.next = head

        var p = head.next
        var pre: ListNode = head
        var next: ListNode? = null
        while (p != null) {

            var insert = false
            var q: ListNode? = fakeHead
            next = p.next
            while (q?.next != null && p != q.next) {
                if (p.`val` < q.next!!.`val`) {
                    pre.next = next
                    p.next = q.next
                    q.next = p
                    insert = true
                    break
                }

                q = q.next
            }

            if (!insert) {
                pre = p
            }

            p = next
        }

        val newHead = fakeHead.next
        fakeHead.next = null

        return newHead
    }
}