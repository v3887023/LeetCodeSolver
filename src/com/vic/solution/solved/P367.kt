package com.vic.solution.solved

/**
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 【示例 1】
 * 输入：16
 * 输出：True
 *
 * 【示例 2】
 * 输入：14
 * 输出：False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P367 {
    fun isPerfectSquare(num: Int): Boolean {
        var low = 0L
        var high = num.toLong()

        while (low <= high) {
            val mid = (low + high).ushr(1)
            val n = mid * mid

            when {
                n > num -> high = mid - 1
                n < num -> low = mid + 1
                else -> return true
            }
        }

        return false
    }
}