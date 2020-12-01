package com.vic.solution.solved

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 【进阶】
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * 【示例 1】
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * 【示例 2】
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 *
 * 【示例 3】
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * 【提示】
 * 1. 0 <= nums.length <= 10^5
 * 2. -10^9 <= nums[i] <= 10^9
 * 3. nums 是一个非递减数组
 * 4. -10^9 <= target <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P34 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val result = intArrayOf(-1, -1)

        val index = binarySearch(nums, 0, target)
        if (index in nums.indices && nums[index] == target) {
            result[0] = index
        }

        if (result[0] >= 0) {
            result[1] = if (result[0] + 1 !in nums.indices) {
                result[0]
            } else {
                binarySearch(nums, result[0] + 1, target + 1) - 1
            }
        }

        return result
    }

    private fun binarySearch(nums: IntArray, start: Int, target: Int): Int {
        var low = start
        var high = nums.lastIndex

        while (low <= high) {
            val mid = (high + low).ushr(1)
            if (nums[mid] < target) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }

        return low
    }
}