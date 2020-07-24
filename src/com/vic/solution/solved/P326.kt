package com.vic.solution.solved

/**
 * 326. 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 【示例 1】
 * 输入: 27
 * 输出: true
 *
 * 【示例 2】
 * 输入: 0
 * 输出: false
 *
 * 【示例 3】
 * 输入: 9
 * 输出: true
 *
 * 【示例 4】
 * 输入: 45
 * 输出: false
 *
 * 【进阶】
 * 你能不使用循环或者递归来完成本题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P326 {
    fun isPowerOfThree(n: Int): Boolean {
        return n > 0 && 1162261467 % n == 0
    }
}