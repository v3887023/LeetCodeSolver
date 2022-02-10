package com.vic.solution.solved

import com.vic.solution.common.TreeNode
import java.util.*

/**
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 * 【示例】
 * 输入：
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 * 【提示】
 * 节点值的范围在32位有符号整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P637 {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val list = ArrayList<Double>()
        val queue = LinkedList<TreeNode>()

        root?.let { queue.offer(it) }
        while (queue.isNotEmpty()) {
            val size = queue.size
            var sum = 0L    // 注意可能溢出，需要用 Long 类型保存每一层的和
            for (i in 1..size) {
                val node = queue.poll()
                sum += node.`val`
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }

            list.add(sum.toDouble() / size)
        }

        return list.toDoubleArray()
    }
}