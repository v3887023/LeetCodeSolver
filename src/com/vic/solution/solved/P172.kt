package com.vic.solution.solved

/**
 * 172. 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 【示例 1】
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 *
 * 【示例 2】
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 *
 * 【说明】
 * 你算法的时间复杂度应为 O(log n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P172 {
    fun trailingZeroes(n: Int): Int {
        var count = 0
        // divider 有可能溢出，需要使用 Long 类型
        var divider = 5L
        val x = n.toLong()
        while (divider <= x) {
            count += (x / divider).toInt()
            divider *= 5
        }

        return count
    }
}