package com.vic.solution.solved

import com.vic.solution.TreeNode
import java.util.*

/**
 * 965. 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 * 【示例 1】
 *     1
 *    / \
 *   1   1
 *  / \   \
 * 1   1   1
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 *
 * 【示例 2】
 *     2
 *    / \
 *   2   2
 *  / \
 * 5   2
 * 输入：[2,2,2,5,2]
 * 输出：false
 *
 * 【提示】
 * 1. 给定树的节点数范围是 [1, 100]。
 * 2. 每个节点的值都是整数，范围为 [0, 99] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/univalued-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P965 {
    fun isUnivalTree(root: TreeNode?): Boolean {
        if (root == null) {
            throw IllegalArgumentException("root == null")
        }

        val rootValue = root.`val`
        val stack = LinkedList<TreeNode>()
        var p = root
        while (stack.isNotEmpty() || p != null) {
            p = if (p == null) {
                stack.pop().right
            } else {
                if (p.`val` != rootValue) {
                    return false
                }

                stack.push(p)
                p.left
            }
        }

        return true
    }
}