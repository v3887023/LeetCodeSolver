package com.vic.solution.solved

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 【说明】
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 【示例】
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var j = m - 1
        var k = n - 1

        for (i in ((m + n - 1) downTo 0)) {
            if (j >= 0 && k >= 0) {
                if (nums1[j] > nums2[k]) {
                    nums1[i] = nums1[j--]
                } else {
                    nums1[i] = nums2[k--]
                }
            } else if (k >= 0) {
                nums1[i] = nums2[k--]
            } else {
                break
            }
        }
    }
}