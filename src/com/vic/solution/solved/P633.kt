package com.vic.solution.solved

import kotlin.math.sqrt

/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。
 *
 * 【示例1】
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *
 * 【示例2】
 * 输入: 3
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P633 {
    fun judgeSquareSum(c: Int): Boolean {
        var a = 0

        var n = a * a
        while (n in 0..c) {
            val m = c - n
            val b = sqrt(m.toFloat()).toInt()
            if (m == b * b) {
                return true
            }

            a++
            n = a * a
        }

        return false
    }
}