package com.vic.solution.solved

/**
 * 728. 自除数
 * 自除数 是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 还有，自除数不允许包含 0 。
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 【示例】
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 *
 * 【注意】
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-dividing-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P728 {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val list = ArrayList<Int>()

        for (n in left..right) {
            if (n.selfDividing()) {
                list.add(n)
            }
        }

        return list
    }

    private fun Int.selfDividing(): Boolean {
        var x = this

        while (x > 0) {
            val divider = x % 10
            if (divider == 0 || this % divider != 0) {
                return false
            }
            x /= 10
        }

        return true
    }
}