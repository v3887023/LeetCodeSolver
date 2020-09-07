package com.vic.solution.solved

import kotlin.math.min

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 【示例 1】
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 【示例 2】
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 【说明】
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P322 {
    fun coinChange(coins: IntArray, amount: Int): Int {
        // dp[i] 表示凑出金额 i 时需要的最小硬币数
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0

        for (i in 1..amount) {
            for (coin in coins) {
                val remain = i - coin
                if (remain < 0) {
                    continue
                } else {
                    dp[i] = min(dp[i], dp[remain] + 1)
                }
            }
        }

        return if (dp[amount] == amount + 1) -1 else dp[amount]
    }
}