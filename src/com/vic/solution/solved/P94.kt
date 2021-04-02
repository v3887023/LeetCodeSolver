package com.vic.solution.solved

import com.vic.solution.common.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 【示例】
 * 输入: [1,null,2,3]
 *  1
 *   \
 *    2
 *   /
 * 3
 *
 * 输出: [1,3,2]
 *
 * 【进阶】
 * 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P94 {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = ArrayList<Int>()
        val stack = LinkedList<TreeNode>()

        var p = root
        while (stack.isNotEmpty() || p != null) {
            p = if (p == null) {
                val node = stack.pop()
                list.add(node.`val`)
                node.right
            } else {
                stack.push(p)
                p.left
            }
        }

        return list
    }

    fun inorderTraversal2(root: TreeNode?): List<Int> {
        val list = ArrayList<Int>()

        root?.let {
            list.addAll(inorderTraversal2(it.left))
            list.add(it.`val`)
            list.addAll(inorderTraversal2(it.right))
        }

        return list
    }
}