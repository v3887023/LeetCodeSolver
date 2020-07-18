package com.vic.solution

import kotlin.math.min

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 
 * (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 【示例】
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P11 {
    fun maxArea(height: IntArray): Int {
        var max = 0

        var i = 0
        val size = height.size
        while (i < size) {
            var j = i + 1
            while (j < size) {
                val area = (j - i) * min(height[i], height[j])
                if (area > max) {
                    max = area
                }
                j++
            }
            i++
        }

        return max
    }

    fun maxArea2(height: IntArray): Int {
        var max = 0

        var i = 0
        var j = height.size - 1

        while (i < j) {
            val lower = min(height[i], height[j])
            val area = (j - i) * lower
            if (area > max) {
                max = area
            }

            if (height[i] < height[j]) {
                i++
            } else {
                j--
            }
        }

        return max
    }
}