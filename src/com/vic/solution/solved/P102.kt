package com.vic.solution.solved

import com.vic.solution.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *   3
 *  / \
 * 9  20
 *   /  \
 * 15   7
 *
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P102 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val queue = LinkedList<TreeNode>()

        root?.let { queue.offer(it) }

        while (queue.isNotEmpty()) {
            val size = queue.size
            val list = ArrayList<Int>(size)
            for (i in 1..size) {
                val node = queue.poll()
                list.add(node.`val`)
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            result.add(list)
        }

        return result
    }
}