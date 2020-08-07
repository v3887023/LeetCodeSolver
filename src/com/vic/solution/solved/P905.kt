package com.vic.solution.solved

/**
 * 905. 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中，A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 * 【示例】
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *
 * 【提示】
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P905 {
    fun sortArrayByParity(A: IntArray): IntArray {
        var i = 0
        var j = A.lastIndex

        while (i < j) {
            val n1 = A[i]
            if (n1.isEven()) {
                i++
                continue
            }

            val n2 = A[j]
            if (n2.isOdd()) {
                j--
                continue
            }

            A[i++] = n2
            A[j--] = n1
        }

        return A
    }

    private fun Int.isOdd(): Boolean = this and 1 == 1

    private fun Int.isEven(): Boolean = this and 1 == 0
}