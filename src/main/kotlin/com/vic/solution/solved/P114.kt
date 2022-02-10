package com.vic.solution.solved

import com.vic.solution.common.TreeNode

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 例如，给定二叉树
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * 将其展开为：
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P114 {
    fun flatten(root: TreeNode?): Unit {
        if (root == null) {
            return
        }

        val left = root.left
        val right = root.right
        flatten(left)
        flatten(right)

        val lastNode = findLastNode(left)
        root.left = null

        if (lastNode != null) {
            lastNode.right = right
            root.right = left
        }
    }

    private fun findLastNode(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        root.right?.let {
            return findLastNode(it)
        }

        root.left?.let {
            return findLastNode(it)
        }

        return root
    }
}