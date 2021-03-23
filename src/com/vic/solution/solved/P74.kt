package com.vic.solution.solved

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。
 *
 * 该矩阵具有如下特性：
 * 1. 每行中的整数从左到右按升序排列。
 * 2. 每行的第一个整数大于前一行的最后一个整数。
 *
 * 【示例 1】
 *   1   3   5   7
 *  10  11  16  20
 *  23  30  34  60
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 【示例 2】
 *   1   3   5   7
 *  10  11  16  20
 *  23  30  34  60
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 * 【提示】
 * 1. m == matrix.length
 * 2. n == matrix[i].length
 * 3. 1 <= m, n <= 100
 * 4. -104 <= matrix[i][j], target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P74 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size

        var low = 0
        var high = m * n - 1

        while (low <= high) {
            val mid = (low + high) ushr 1
            val number = getNumberByIndex(matrix, mid)

            when {
                number < target -> low = mid + 1
                number > target -> high = mid - 1
                number == target -> return true
            }
        }

        return false
    }

    private fun getNumberByIndex(matrix: Array<IntArray>, index: Int): Int {
        val n = matrix[0].size
        val i = index / n
        val j = index % n

        return matrix[i][j]
    }
}