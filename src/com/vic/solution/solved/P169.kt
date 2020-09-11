package com.vic.solution.solved

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 n/2 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 【示例 1】
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 【示例 2】
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P169 {
    fun majorityElement(nums: IntArray): Int {
        val map = HashMap<Int, Int>()

        nums.forEach {
            map[it] = (map[it] ?: 0) + 1
        }

        val minCount = nums.size / 2
        for ((n, count) in map) {
            if (count > minCount) {
                return n
            }
        }

        return -1
    }

    fun majorityElement2(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size / 2]
    }

    // TODO 多数元素 分治版本
    fun majorityElement3(nums: IntArray): Int {
        return 0
    }
}