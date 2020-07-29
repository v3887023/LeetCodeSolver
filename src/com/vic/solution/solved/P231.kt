package com.vic.solution.solved

/**
 * 231. 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 【示例 1】
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 *
 * 【示例 2】
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 *
 * 【示例 3】
 * 输入: 218
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P231 {
    fun isPowerOfTwo(n: Int): Boolean {
        if (n <= 0) {
            return false
        }

        if (n == 1) {
            return true
        }

        var x = n
        while (x % 2 == 0) {
            x /= 2
        }

        return x == 0
    }

    fun isPowerOfTwo2(n: Int): Boolean {
        return n > 0 && n and (n - 1) == 0
    }
}