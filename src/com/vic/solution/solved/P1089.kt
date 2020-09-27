package com.vic.solution.solved

/**
 * 1089. 复写零
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *
 * 【注意】
 * 请不要在超过该数组长度的位置写入元素。
 *
 * 【要求】
 * 请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 * 【示例 1】
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 *
 * 【示例 2】
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *
 * 【提示】
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/duplicate-zeros
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P1089 {
    fun duplicateZeros(arr: IntArray): Unit {
        val size = arr.size

        var lastIndex = 0
        var newSize = 0
        var zeroCount = 0
        for ((i, n) in arr.withIndex()) {
            newSize += if (n == 0) {
                zeroCount++
                2
            } else {
                1
            }

            if (newSize >= size) {
                lastIndex = i
                break
            }
        }


        var i = size - 1
        if (newSize > size) {
            arr[i--] = 0
            lastIndex--
            zeroCount--
        }

        while (i >= 0 && zeroCount > 0) {
            val n = arr[lastIndex--]
            if (n == 0) {
                arr[i] = n
                arr[i - 1] = n
                i -= 2
                zeroCount--
            } else {
                arr[i--] = n
            }
        }
    }
}