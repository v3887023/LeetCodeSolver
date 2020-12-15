package com.vic.solution.solved

import com.vic.solution.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 * 【示例】
 * 输入: [1,null,2,3]
 *  1
 *   \
 *    2
 *   /
 * 3
 *
 * 输出: [1,2,3]
 *
 * 【进阶】
 * 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P144 {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        val stack = LinkedList<TreeNode>()
        var p = root
        while (stack.isNotEmpty() || p != null) {
            p = if (p == null) {
                stack.pop().right
            } else {
                list.add(p.`val`)
                stack.push(p)
                p.left
            }
        }

        return list
    }

    fun preorderTraversal2(root: TreeNode?): List<Int> {
        val list = ArrayList<Int>()

        root?.let {
            list.addAll(preorderTraversal2(it.left))
            list.add(it.`val`)
            list.addAll(preorderTraversal2(it.right))
        }

        return list
    }
}