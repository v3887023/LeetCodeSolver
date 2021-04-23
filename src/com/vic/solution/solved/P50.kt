package com.vic.solution.solved

/**
 * 50. Pow(x, n)
 * 实现pow(x, n)，即计算 x 的 n 次幂函数（即，x^n）。
 *
 * 【示例 1】
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 【示例 2】
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 【示例 3】
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * 【提示】
 * -100.0 <x< 100.0
 * -2^31 <= n <= 2^31-1
 * -10^4 <= x^n <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P50 {
    fun myPow(x: Double, n: Int): Double {
        var result = 1.0
        var base = x
        val negative = n < 0
        // 这里可能溢出，需要用 Long 类型保存
        var b: Long = if (negative) -n.toLong() else n.toLong()
        while (b > 0) {
            if (b.toInt() and 1 == 1) {
                result *= base
            }

            base *= base
            b = b shr 1
        }

        return if (negative) 1 / result else result
    }
}