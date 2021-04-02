package com.vic.solution.solved

import com.vic.solution.common.TreeNode
import java.util.*

/**
 * 872. 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 *        3
 *     /    \
 *   5       1
 *  / \    /  \
 * 6   2  9    8
 *   /  \
 *  7    4
 *
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * 【示例 1】
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 *
 * 【示例 2】
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 *
 * 【示例 3】
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 *
 * 【示例 4】
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 *
 * 【示例 5】
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 *
 * 【提示】
 * 给定的两棵树可能会有 1 到 200 个结点。
 * 给定的两棵树上的值介于 0 到 200 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P872 {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        return getLeaves(root1) == getLeaves(root2)
    }

    private fun TreeNode.isLeaf() = left == null && right == null

    private fun getLeaves(root: TreeNode?): String {
        val sb = StringBuilder()

        val stack = LinkedList<TreeNode>()
        var p = root
        while (stack.isNotEmpty() || p != null) {
            p = if (p == null) {
                stack.pop().right
            } else {
                if (p.isLeaf()) {
                    sb.append(p.`val`).append(',')
                }

                stack.push(p)
                p.left
            }
        }

        return sb.toString()
    }
}