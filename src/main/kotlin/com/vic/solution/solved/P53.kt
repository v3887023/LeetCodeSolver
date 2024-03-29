package com.vic.solution.solved

import kotlin.math.max

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 【示例】
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 【进阶】
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P53 {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        // dp[i] 表示以 nums[i] 结尾的“最大子序和”
        val dp = IntArray(nums.size)
        dp[0] = nums[0]

        for (i in 1 until nums.size) {
            dp[i] = max(nums[i], nums[i] + dp[i - 1])
        }

        return dp.maxOrNull() ?: 0
    }

    fun maxSubArray2(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        var former = nums[0]
        var max = former

        for (i in 1 until nums.size) {
            val current = max(nums[i], nums[i] + former)
            if (current > max) {
                max = current
            }

            former = current
        }

        return max
    }
}