package com.vic.solution.solved

import com.vic.solution.TreeNode
import java.util.*

/**
 * 515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 【示例】
 * 输入:
 *     1
 *    / \
 *   3   2
 *  / \   \
 * 5   3   9
 * 输出: [1, 3, 9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P515 {
    fun largestValues(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        val queue = LinkedList<TreeNode>()
        root?.let { queue.offer(it) }

        while (queue.isNotEmpty()) {
            val count = queue.size

            var maxValue = Int.MIN_VALUE
            repeat(count) {
                val node = queue.poll()
                if (node.`val` > maxValue) {
                    maxValue = node.`val`
                }

                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }

            result.add(maxValue)
        }

        return result
    }
}