package com.vic.solution.solved

import kotlin.collections.ArrayList

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 【示例】
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P118 {
    fun generate(numRows: Int): List<List<Int>> {
        val result: MutableList<MutableList<Int>> = ArrayList()

        for (i in 0 until numRows) {
            val list = ArrayList<Int>(i + 1)
            list.add(1)
            if (i > 0) {
                val formerList = result[i - 1]
                for (j in 1..i) {
                    if (j < formerList.size) {
                        list.add(formerList[j - 1] + formerList[j])
                    }
                }
                list.add(1)
            }

            result.add(list)
        }

        return result
    }

    fun generate2(numRows: Int): List<List<Int>> {
        val result = MutableList(numRows) { i -> MutableList(i + 1) { 1 } }

        for (i in 2 until numRows) {
            val list = result[i]
            val formerList = result[i - 1]
            for (j in 1 until i) {
                list[j] = formerList[j - 1] + formerList[j]
            }
        }

        return result
    }
}