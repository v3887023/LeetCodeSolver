package com.vic.solution.solved

import kotlin.math.sqrt

/**
 * 342. 4的幂
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 【示例 1】
 * 输入: 16
 * 输出: true
 *
 * 【示例 2】
 * 输入: 5
 * 输出: false
 *
 * 【进阶】
 * 你能不使用循环或者递归来完成本题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P342 {
    fun isPowerOfFour(num: Int): Boolean {
        val x = sqrt(num.toDouble()).toInt()
        return x * x == num && x > 0 && x and (x - 1) == 0
    }

    fun isPowerOfFour2(num: Int): Boolean {
        return num > 0 && num and (num - 1) == 0 && num % 3 == 1
    }

    fun isPowerOfFour3(num: Int): Boolean {
        return num > 0 && num and (num - 1) == 0 && (num and 0x55555555) == num
    }
}