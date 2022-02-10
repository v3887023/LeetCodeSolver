package com.vic.solution.solved

import com.vic.solution.common.ListNode

/**
 * 414. 第三大的数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 【示例 1】
 * 输入: [3, 2, 1]
 * 输出: 1
 * 解释: 第三大的数是 1.
 *
 * 【示例 2】
 * 输入: [1, 2]
 * 输出: 2
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 *
 * 【示例 3】
 * 输入: [2, 2, 3, 1]
 * 输出: 1
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。存在两个值为2的数，它们都排第二。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P414 {
    fun thirdMax(nums: IntArray): Int {
        val head = ListNode(-1)
        head.next = ListNode(nums[0])

        for (j in 1..nums.lastIndex) {
            val n = nums[j]
            var p = head.next
            // 非首节点
            var pre = head
            var count = 0
            while (p != null && count < 3) {
                val m = p.`val`
                if (n > m) {
                    val node = ListNode(n)
                    pre.next = node
                    node.next = p
                    break
                } else if (n == m) {
                    break
                }

                pre = p
                p = p.next
                count++
            }

            if (p == null) {
                pre.next = ListNode(n)
            }
        }

        var p = head.next
        var count = 0
        while (p != null && count < 2) {
            p = p.next
            count++
        }

        return p?.`val` ?: head.next!!.`val`
    }
}