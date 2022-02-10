package com.vic.solution.solved

import com.vic.solution.common.TreeNode
import java.util.*

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 【说明】
 * 叶子节点是指没有子节点的节点。
 *
 * 【示例】
 * 给定如下二叉树，以及目标和 sum = 22，
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * 返回:
 * [
 *   [5,4,11,2],
 *   [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P1022 {
    fun sumRootToLeaf(root: TreeNode?): Int {
        val stack = LinkedList<TreeNode>()
        val shouldVisitMap = mutableMapOf<TreeNode, Boolean>()
        var sum = 0

        var p = root
        while (stack.isNotEmpty() || p != null) {
            if (p == null) {
                val parent = stack.peek()
                if (shouldVisitMap[parent] == true) {
                    stack.pop()
                } else {
                    shouldVisitMap[parent] = true
                    p = parent.right
                }
            } else {
                if (p.isLeaf()) {
                    sum += getNumber(stack, p)
                }

                stack.push(p)
                shouldVisitMap[p] = false
                p = p.left
            }
        }

        return sum
    }

    private fun TreeNode.isLeaf() = left == null && right == null

    private fun getNumber(stack: List<TreeNode>, leafNode: TreeNode): Int {
        var result = leafNode.`val`

        var i = 1
        for (node in stack) {
            result = result or (node.`val` shl i)
            i++
        }

        return result
    }
}