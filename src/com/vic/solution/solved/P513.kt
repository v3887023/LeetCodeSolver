package com.vic.solution.solved

import com.vic.solution.TreeNode
import java.util.*

/**
 * 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 【示例 1】
 * 输入:
 *   2
 *  / \
 * 1   3
 * 输出:
 * 1
 *
 * 【示例 2】
 * 输入:
 *     1
 *    / \
 *   2   3
 *  /   / \
 * 4   5   6
 *   /
 *  7
 * 输出:
 * 7
 *
 * 【注意】
 * 您可以假设树（即给定的根节点）不为 NULL。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P513 {
    fun findBottomLeftValue(root: TreeNode?): Int {
        var bottomLeftValue = 0
        val queue = LinkedList<TreeNode>()
        root?.let { queue.offer(it) }

        while (queue.isNotEmpty()) {
            val count = queue.size

            bottomLeftValue = queue.peek().`val`

            repeat(count) {
                val node = queue.poll()
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
        }

        return bottomLeftValue
    }
}