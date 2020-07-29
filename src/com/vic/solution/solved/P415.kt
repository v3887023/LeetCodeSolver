package com.vic.solution.solved

import java.util.*

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和 num2，计算它们的和。
 *
 * 【注意】
 * num1 和 num2 的长度都小于 5100.
 * num1 和 num2 都只包含数字 0-9.
 * num1 和 num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P415 {
    fun addStrings(num1: String, num2: String): String {
        var i = num1.lastIndex
        var j = num2.lastIndex

        var carry = 0
        val list = LinkedList<Char>()
        while (i >= 0 && j >= 0) {
            val n = num1[i] + num2[j] + carry
            carry = n / 10
            list.addFirst(n % 10 + '0')
            i--
            j--
        }

        while (i >= 0) {
            val n = num1[i] - '0' + carry
            carry = n / 10
            list.addFirst(n % 10 + '0')
            i--
        }

        while (j >= 0) {
            val n = num2[j] - '0' + carry
            carry = n / 10
            list.addFirst(n % 10 + '0')
            j--
        }

        if (carry > 0) {
            list.addFirst(carry + '0')
        }

        return String(list.toCharArray())
    }

    private operator fun Char.plus(another: Char): Int {
        return (this - '0') + (another - '0')
    }

    private operator fun Int.plus(c: Char): Char {
        return (this + c.toInt()).toChar()
    }
}