package com.vic.solution.solved

/**
 * 868. 二进制间距
 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个相邻 1 之间的最长距离。
 *
 * 如果没有两个相邻的 1，返回 0 。
 *
 * 【示例 1】
 * 输入：22
 * 输出：2
 * 解释：
 * 22 的二进制是 0b10110 。
 * 在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
 * 第一对相邻的 1 中，两个 1 之间的距离为 2 。
 * 第二对相邻的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 *
 * 【示例 2】
 * 输入：5
 * 输出：2
 * 解释：
 * 5 的二进制是 0b101 。
 *
 * 【示例 3】
 * 输入：6
 * 输出：1
 * 解释：
 * 6 的二进制是 0b110 。
 *
 * 【示例 4】
 * 输入：8
 * 输出：0
 * 解释：
 * 8 的二进制是 0b1000 。
 * 在 8 的二进制表示中没有相邻的两个 1，所以返回 0 。
 *
 * 【提示】
 * 1 <= N <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-gap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P868 {
    fun binaryGap(N: Int): Int {
        var maxGap = 0
        var x = N

        var lastOneIndex = -1
        for (i in 31 downTo 1) {
            if (x and 1 == 1) {
                if (lastOneIndex != -1) {
                    val gap = lastOneIndex - i
                    if (gap > maxGap) {
                        maxGap = gap
                    }
                }

                lastOneIndex = i
            }

            x = x shr 1
        }

        return maxGap
    }
}