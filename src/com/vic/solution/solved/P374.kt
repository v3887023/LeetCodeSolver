package com.vic.solution.solved

/**
 * 374. 猜数字大小
 * 猜数字游戏的规则如下：
 * 每轮游戏，系统都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，系统会告诉你这个数字比系统选出的数字是大了还是小了。
 *
 * 你可以通过调用一个预先定义好的接口 guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * -1 : 系统选出的数字比你猜测的数字小
 * 1 : 系统选出的数字比你猜测的数字大
 * 0 : 恭喜！你猜对了！
 *
 * 【示例】
 * 输入: n = 10, pick = 6
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P374 {
    fun guessNumber(n: Int): Int {
        var low = 0
        var high = n

        while (low <= high) {
            val mid = (low + high).ushr(1)
            val result = guess(mid)
            when {
                result < 0 -> high = mid - 1
                result == 0 -> return mid
                result > 0 -> low = mid + 1
            }
        }

        return -1
    }

    private fun guess(num: Int): Int {
        // Implementation provided by LeetCode
        return 0
    }
}