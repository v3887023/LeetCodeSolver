package com.vic.solution.solved

import com.vic.solution.common.TreeNode

/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 【示例】
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


class P404 {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        return if (root == null || root.isLeaf()) 0 else realSumOfLeftLeaves(root)
    }

    private fun realSumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        if (root.isLeaf()) {
            return root.`val`
        }

        var sum = realSumOfLeftLeaves(root.left)
        root.right?.run {
            if (!isLeaf()) {
                sum += realSumOfLeftLeaves(this)
            }
        }

        return sum
    }

    private fun TreeNode.isLeaf(): Boolean {
        return left == null && right == null
    }
}