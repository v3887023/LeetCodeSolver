package com.vic.solution.solved

/**
 * 371. 两整数之和
 * 不使用运算符 + 和 -，计算两整数 a 、b 之和。
 *
 * 【示例 1】
 * 输入: a = 1, b = 2
 * 输出: 3
 *
 * 【示例 2】
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P371 {
    fun getSum(a: Int, b: Int): Int {
        var x = a
        var y = b

        var sum = 0
        var index = 0
        var carry = 0
        while ((x != 0 || y != 0 || carry > 0) && index < 32) {
            val n1 = x and 1
            val n2 = y and 1
            sum = sum or ((n1 xor n2 xor carry) shl index)

            carry = (n1 and n2) or (n1 and carry) or (n2 and carry)

            x = x ushr 1
            y = y ushr 1
            index++
        }

        return sum
    }
}