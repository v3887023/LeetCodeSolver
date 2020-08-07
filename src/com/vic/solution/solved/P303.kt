package com.vic.solution.solved

/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 【示例】
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * 【说明】
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P303 {
    class NumArray(nums: IntArray) {
        val sumArray = IntArray(nums.size)

        init {
            var sum = 0
            for ((i, n) in nums.withIndex()) {
                sum += n
                sumArray[i] = sum
            }
        }

        fun sumRange(i: Int, j: Int): Int = sumArray[j] - if (i == 0) 0 else sumArray[i - 1]
    }
}
