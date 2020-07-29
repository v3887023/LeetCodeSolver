package com.vic.solution.solved

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 【示例 1】
 * 输入: 4
 * 输出: 2
 *
 * 【示例 2】
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P69 {
    fun mySqrt(x: Int): Int {
        for (i in 0..x) {
            val n = i * i.toLong()
            if (n > x) {
                return i - 1
            } else if (n.toInt() == x) {
                return i
            }
        }

        return 0
    }

    fun mySqrt2(x: Int): Int {
        var low = 0L
        var high = x.toLong()

        val target = x.toLong()
        var answer = 0L
        while (low <= high) {
            val mid = (low + high).ushr(1)

            if (mid * mid <= target) {
                answer = mid
                low = mid + 1
            } else {
                high = mid - 1
            }
        }

        return answer.toInt()
    }
}