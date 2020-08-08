package com.vic.solution.unsolved

import com.vic.solution.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 【示例】
 * 输入: [1,null,2,3]
 *   1
 *    \
 *     2
 *   /
 * 3
 *
 * 输出: [3,2,1]
 *
 * 【进阶】
 * 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P145 {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val list = ArrayList<Int>()
        val stack = LinkedList<TreeNode>()

        var p = root
        while (stack.isNotEmpty() || p != null) {
            if (p == null) {
                val node = stack.pop()
                list.add(node.`val`)
                p = stack.peek().right
            } else if (p.left != null) {
                stack.push(p)
                p = p.left
            } else if (p.right != null) {
                stack.push((p))
                p = p.right
            } else {
                stack.push(p)
                p = null
            }
        }

        return list
    }

    fun postorderTraversal2(root: TreeNode?): List<Int> {
        val list = ArrayList<Int>()

        root?.let {
            list.addAll(postorderTraversal2(it.left))
            list.addAll(postorderTraversal2(it.right))
            list.add(it.`val`)
        }

        return list
    }
}