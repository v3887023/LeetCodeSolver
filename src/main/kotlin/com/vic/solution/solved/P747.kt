package com.vic.solution.solved

/**
 * 747. 至少是其他数字两倍的最大数
 * 在一个给定的数组 nums 中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回 -1。
 *
 * 【示例 1】
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6 是最大的整数, 对于数组中的其他整数,
 * 6 大于数组中其他元素的两倍。6 的索引是 1, 所以我们返回 1.
 *
 * 【示例 2】
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4 没有超过 3 的两倍大, 所以我们返回 -1.
 *
 * 【提示】
 * nums 的长度范围在 [1, 50].
 * 每个 nums[i] 的整数范围在 [0, 100].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P747 {
    fun dominantIndex(nums: IntArray): Int {
        var max = Int.MIN_VALUE
        var maxIndex = -1
        nums.forEachIndexed { index, n ->
            if (n > max) {
                max = n
                maxIndex = index
            }
        }

        nums.forEach {
            if (it != max && it * 2 > max) {
                return -1
            }
        }

        return maxIndex
    }
}