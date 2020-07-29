package com.vic.solution.solved

/**
 * 264. 丑数 II
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 *
 * 【示例】
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 【说明】
 * 1 是丑数。
 * n 不超过1690。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P264 {
    fun nthUglyNumber(n: Int): Int {
        if (n <= 0) {
            return 0
        }

        var i2 = 0
        var i3 = 0
        var i5 = 0

        val list = ArrayList<Int>()
        list.add(1)

        while (list.size < n) {
            val n2 = list[i2] * 2
            val n3 = list[i3] * 3
            val n5 = list[i5] * 5

            val min = minOf(n2, n3,n5)
            list.add(min)

            if (min == n2) {
                i2++
            }

            if (min == n3) {
                i3++
            }

            if (min == n5) {
                i5++
            }
        }

        return list.last()
    }
}