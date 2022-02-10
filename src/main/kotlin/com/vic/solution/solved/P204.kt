package com.vic.solution.solved

import kotlin.math.sqrt

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 【示例】
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P204 {
    fun countPrimes(n: Int): Int {
        var count = 0

        for (i in 2 until n) {
            if (i.isPrime()) {
                count++
            }
        }

        return count
    }

    private fun Int.isEven(): Boolean {
        return this % 2 == 0
    }

    private fun Int.isPrime(): Boolean {
        when {
            this < 2 -> return false
            this == 2 -> return true
            this.isEven() -> return false
        }

        for (x in 2..sqrt(this.toFloat()).toInt()) {
            if (this % x == 0) {
                return false
            }
        }

        return true
    }
}