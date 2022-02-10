package com.vic.solution.solved

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是 无限循环 但始终变不到 1。如果 可以变为 1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *
 * 【示例】
 * 输入：19
 * 输出：true
 * 解释：
 * 1 + 81 = 82
 * 64 + 4 = 68
 * 36 + 64 = 100
 * 1 + 0 + 0 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P202 {
    fun isHappy(n: Int): Boolean {
        val set = HashSet<Int>()

        var x = n
        while (x != 1) {
            x = x.squareSumOfEveryDigit()
            if (!set.add(x)) {
                return false
            }
        }

        return true
    }

    private fun Int.squareSumOfEveryDigit(): Int {
        var x = this
        var result = 0
        while (x > 0) {
            val a = x % 10
            result += a * a

            x /= 10
        }

        return result
    }
}