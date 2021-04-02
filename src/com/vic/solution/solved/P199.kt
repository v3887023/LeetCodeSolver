package com.vic.solution.solved

import com.vic.solution.common.TreeNode
import java.util.*

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 【示例】
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P199 {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        val queue = LinkedList<TreeNode>()
        root?.let { queue.offer(it) }

        while (queue.isNotEmpty()) {
            val count = queue.size

            for (i in 0 until count) {
                val treeNode = queue.poll()
                treeNode.left?.let { queue.offer(it) }
                treeNode.right?.let { queue.offer(it) }

                treeNode.takeIf { i == count - 1 }?.let { result.add(it.`val`) }
            }
        }

        return result
    }
}