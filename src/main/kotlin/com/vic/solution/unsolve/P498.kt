package com.vic.solution.unsolve

import com.vic.solution.println

/**
 * 498. 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 * 【示例】
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * 解释: （图片无法显示）
 *
 * 【说明】
 * 给定矩阵中的元素总数不会超过 100000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P498 {
    fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
        val m = matrix.size
        val n = matrix[0].size
        val result = IntArray(m * n)

        var i = 0
        var j = 0
        var index = 0

        while (i < m && j < n) {
            val num = matrix[i][j]
        }

        return result
    }
}

fun main() {
    P498().findDiagonalOrder(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))).println()
}