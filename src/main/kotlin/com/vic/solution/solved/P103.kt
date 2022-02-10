package com.vic.solution.solved

import com.vic.solution.common.TreeNode
import java.util.*

/**
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 【例如】
 * 给定二叉树 [3,9,20,null,null,15,7],
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P103 {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val queue = LinkedList<TreeNode>()

        var level = 0

        root?.let { queue.offer(it) }

        while (queue.isNotEmpty()) {
            val list = ArrayList<Int>()
            repeat(queue.size) {
                val node = queue.poll()
                list.add(node.`val`)
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }

            if (level and 1 == 1) {
                result.add(list.reversed())
            } else {
                result.add(list)
            }

            level++
        }

        return result
    }
}