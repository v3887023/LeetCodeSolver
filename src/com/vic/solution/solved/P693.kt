package com.vic.solution.solved

/**
 * 693. 交替位二进制数
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 *
 * 【示例 1】
 * 输入: 5
 * 输出: True
 * 解释: 5的二进制数是: 101
 *
 * 【示例 2】
 * 输入: 7
 * 输出: False
 * 解释: 7的二进制数是: 111
 *
 * 【示例 3】
 * 输入: 11
 * 输出: False
 * 解释: 11的二进制数是: 1011
 *
 * 【示例 4】
 * 输入: 10
 * 输出: True
 * 解释: 10的二进制数是: 1010
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-number-with-alternating-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P693 {
    fun hasAlternatingBits(n: Int): Boolean {
        var x = n

        var lastDigit = -1
        while (x > 0) {
            val digit = x and 1
            if (digit == lastDigit) {
                return false
            }
            x = x shr 1
            lastDigit = digit
        }

        return true
    }

    fun hasAlternatingBits2(n: Int): Boolean {
        val x = n xor (n shr 1)
        return x and (x + 1) == 0
    }
}