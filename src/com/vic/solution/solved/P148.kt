package com.vic.solution.solved

import com.vic.solution.common.ListNode

/**
 * 148. 排序链表
 * 给你链表的头结点 head，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 * 你可以在 O (nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 【示例 1】
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 【示例 2】
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 【示例 3】
 * 输入：head = []
 * 输出：[]
 *
 * 【提示】
 * 1. 链表中节点的数目在范围 [0, 5 * 10^4] 内
 * 2. -10^5 <= Node.val <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P148 {
    fun sortList(head: ListNode?): ListNode? {
        // 链表为空或只有一个节点时，直接返回
        head?.next ?: return head

        val fakeHead = ListNode(Int.MIN_VALUE)
        var p = head
        while (p != null) {
            val next = p.next
            p.next = null

            fakeHead.insertOrderly(p)

            p = next
        }

        val newHead = fakeHead.next
        fakeHead.next = null

        return newHead
    }

    private fun ListNode?.insertOrderly(node: ListNode) {
        var p = this

        var pre: ListNode? = null
        while (p != null && p.`val` < node.`val`) {
            pre = p
            p = p.next
        }

        node.next = p
        pre?.next = node
    }
}