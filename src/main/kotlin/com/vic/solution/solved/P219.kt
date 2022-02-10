package com.vic.solution.solved

import kotlin.math.abs

/**
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 * 【示例 1】
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * 【示例 2】
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 *
 * 【示例 3】
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P219 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()

        nums.forEachIndexed { i, n ->
            val j = map[n]

            if (j != null && abs(i - j) <= k) {
                return true
            }

            map[n] = i
        }

        return false
    }
}