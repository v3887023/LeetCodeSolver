package com.vic.solution.solved

import com.vic.solution.common.TreeNode
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
        val list = mutableListOf<Int>()
        val stack = LinkedList<TreeNode>()
        // 保存结点是否可以访问的 map，后序遍历需要左右结点均访问过才能访问当前结点
        val shouldVisitMap = mutableMapOf<TreeNode, Boolean>()

        var p = root
        while (stack.isNotEmpty() || p != null) {
            if (p == null) {
                val parent = stack.peek()
                if (shouldVisitMap[parent] == true) {
                    list.add(parent.`val`)
                    stack.pop()
                } else {
                    // 右结点即将访问，parent 结点将在下一次可访问
                    shouldVisitMap[parent] = true
                    p = parent.right
                }
            } else {
                shouldVisitMap[p] = false
                stack.push(p)
                p = p.left
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