package com.vic.solution.solved

import com.vic.solution.TreeNode
import java.util.*

/**
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 【示例】
 * 输入:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P257 {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val result = mutableListOf<String>()

        val stack = LinkedList<TreeNode>()
        // 保存结点是否可以访问的 map，后序遍历需要左右结点均访问过才能访问当前结点
        val shouldVisitMap = mutableMapOf<TreeNode, Boolean>()
        var p = root
        while (stack.isNotEmpty() || p != null) {
            if (p == null) {
                val parent = stack.peek()
                if (shouldVisitMap[parent] == true) {
                    stack.pop()
                } else {
                    // 右结点即将访问，parent 结点将在下一次可访问
                    shouldVisitMap[parent] = true
                    p = parent.right
                }
            } else {
                if (p.isLeaf()) {
                    result.add(getPath(stack, p))
                }
                shouldVisitMap[p] = false
                stack.push(p)
                p = p.left

            }
        }

        return result
    }

    private fun TreeNode.isLeaf(): Boolean {
        return left == null && right == null
    }

    private fun getPath(stack: List<TreeNode>, leafNode: TreeNode): String {
        return buildString {
            for (i in stack.lastIndex downTo 0) {
                append(stack[i].`val`).append("->")
            }
            append(leafNode.`val`)
        }
    }
}