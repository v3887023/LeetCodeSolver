package com.vic.solution.solved

import com.vic.solution.common.TreeNode
import java.util.*

/**
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 * 【示例 1】
 *      1
 *    /  \
 *   2    3
 *  /
 * 4
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 *
 * 【示例 2】
 *    1
 *  /  \
 * 2    3
 *  \    \
 *   4    5
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 *
 * 【示例 3】
 *    1
 *  /   \
 * 2     3
 *  \
 *   4
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 * 【提示】
 * 1. 二叉树的节点数介于 2 到 100 之间。
 * 2. 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P993 {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        val stack = LinkedList<TreeNode>()
        val shouldVisitMap = mutableMapOf<TreeNode, Boolean>()

        var p = root
        var parent: TreeNode? = null
        var xParent: TreeNode? = null
        var yParent: TreeNode? = null
        var xDepth: Int = -1
        var yDepth: Int = -2
        var depth = 0
        while (stack.isNotEmpty() || p != null) {
            if (p == null) {
                parent = stack.peek()
                if (shouldVisitMap[parent] == true) {
                    stack.pop()
                    depth--
                } else {
                    shouldVisitMap[parent] = true
                    p = parent.right
                }
            } else {
                when (p.`val`) {
                    x -> {
                        xDepth = depth
                        xParent = parent
                    }
                    y -> {
                        yDepth = depth
                        yParent = parent
                    }
                }

                if (xParent != null && yParent != null) {
                    break
                }

                stack.push(p)
                parent = p
                depth++
                p = p.left
            }
        }

        return xDepth == yDepth && xParent != yParent
    }
}