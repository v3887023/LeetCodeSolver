package com.vic.solution.solved

import kotlin.math.min

/**
 * 746. 使用最小花费爬楼梯
 * 数组的每个索引作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 【示例 1】
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15。
 *
 * 【示例 2】
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从 cost[0] 开始，逐个经过那些 1，跳过 cost[3] ，一共花费 6。
 *
 * 【注意】
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个 Integer 类型，范围为 [0, 999]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P746 {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val size = cost.size

        // dp[i] 表示爬上第 i 个阶梯时需要花费的最低花费，注意，必须到达第 i 个阶梯，而不是跨过去
        val dp = IntArray(size)
        dp[0] = cost[0]
        dp[1] = cost[1]

        for (i in 2 until size) {
            dp[i] = min(dp[i - 2], dp[i - 1]) + cost[i]
        }

        // 最后，在第 size - 2 个台阶爬两个阶梯和爬上第 size - 1 个阶梯所需花费中取最小值
        return min(dp[size - 2], dp[size - 1])
    }
}