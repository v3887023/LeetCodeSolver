package com.vic.solution.solved

import com.vic.solution.common.TreeNode
import java.util.*

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *      1
 *     / \
 *   2    2
 *  / \  / \
 * 3  4 4  3
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *   1
 *  / \
 * 2   2
 *  \   \
 *  3    3
 *
 * 【进阶】
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P101 {
    /**
     * TODO 对称二叉树，递归版本
     */
    fun isSymmetric(root: TreeNode?): Boolean {
        return false
    }

    fun isSymmetric2(root: TreeNode?): Boolean {
        val queue = LinkedList<TreeNode?>()

        root?.let { queue.offer(it) }

        var nullCount: Int
        val list = ArrayList<TreeNode?>()
        while (queue.isNotEmpty()) {
            nullCount = 0
            list.clear()

            repeat(queue.size) {
                val node = queue.pop()
                list += node

                queue.offer(node?.left)
                queue.offer(node?.right)

                nullCount += node.nullCount()
            }

            if (!symmetricList(list)) {
                return false
            }

            if (nullCount == queue.size) {
                break
            }
        }

        return true
    }

    private fun TreeNode?.nullCount(): Int {
        var count = 0
        if (this == null) {
            count = 2
        } else {
            count += if (left == null) 1 else 0
            count += if (right == null) 1 else 0
        }

        return count
    }

    private fun symmetricList(list: List<TreeNode?>): Boolean {
        val lastIndex = list.lastIndex
        for (i in 0 until list.size.shr(1)) {
//            if (list[i] != null && list[lastIndex - i] != null && list[i] != list[lastIndex - i] || list[i] == null && list[lastIndex - i] != null || list[i] != null && list[lastIndex - i] == null) {
//                return false
//            }

            if (list[i]?.`val` != list[lastIndex - i]?.`val`) {
                return false
            }
        }

        return true
    }
}