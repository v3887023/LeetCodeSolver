package com.vic.solution.solved

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 【示例 1】
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 * 【示例 2】
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 * 【说明】
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P43 {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") {
            return "0"
        }

        val len1 = num1.length
        val len2 = num2.length

        var sum = "0"
        for ((zeroCount, i) in (num2.lastIndex downTo 0).withIndex()) {
            sum = add(sum, times(num1, num2[i], zeroCount))
        }

        return sum
    }

    fun times(num: String, c: Char, zeroCount: Int): String {
        val sb = StringBuilder()

        var carry = 0
        for (i in num.lastIndex downTo 0) {
            val n1 = num[i] - '0'
            val n2 = c - '0'
            val result = n1 * n2 + carry
            carry = result / 10
            sb.append(result % 10)
        }

        if (carry > 0) {
            sb.append(carry)
        }

        sb.reverse()

        repeat(zeroCount) {
            sb.append('0')
        }

        return sb.toString()
    }

    fun add(num1: String, num2: String): String {
        val sb = StringBuilder()
        var carry = 0
        var i = num1.lastIndex
        var j = num2.lastIndex
        while (i >= 0 || j >= 0) {
            val n1 = if (i < 0) 0 else num1[i--] - '0'
            val n2 = if (j < 0) 0 else num2[j--] - '0'
            val sum = n1 + n2 + carry
            carry = sum / 10
            sb.append(sum % 10)
        }

        if (carry > 0) {
            sb.append(carry)
        }

        return sb.reverse().toString()
    }
}