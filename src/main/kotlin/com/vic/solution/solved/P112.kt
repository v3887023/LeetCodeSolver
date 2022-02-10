package com.vic.solution.solved

import com.vic.solution.common.TreeNode
import java.util.*

/**
 * 112. 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
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
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P112 {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        val stack = LinkedList<TreeNode>()
        val shouldVisitMap = mutableMapOf<TreeNode, Boolean>()

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
                if (p.isLeaf() && getSum(stack, p) == sum) {
                    return true
                }

                stack.push(p)
                shouldVisitMap[p] = false
                p = p.left
            }
        }

        return false
    }

    private fun TreeNode.isLeaf() = left == null && right == null

    private fun getSum(stack: List<TreeNode>, leafNode: TreeNode): Int {
        return leafNode.`val` + stack.sumBy { it.`val` }
    }
}