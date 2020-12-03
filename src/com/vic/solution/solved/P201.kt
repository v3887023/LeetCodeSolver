package com.vic.solution.solved

/**
 * 201. 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 【示例 1】
 * 输入: [5,7]
 * 输出: 4
 *
 * 【示例 2】
 * 输入: [0,1]
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P201 {
    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        var d = 0
        var m2 = m
        var n2 = n

        while (m2 < n2) {
            m2 = m2 shr 1
            n2 = n2 shr 1
            d++
        }

        return m2 shl d
    }

    fun rangeBitwiseAnd2(m: Int, n: Int): Int {
        var n2 = n
        while (m < n2) {
            n2 = n2 and n2 - 1
        }
        return n2
    }
}