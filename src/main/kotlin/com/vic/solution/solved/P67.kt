package com.vic.solution.solved

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 【示例 1】
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 【示例 2】
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 【提示】
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P67 {
    fun addBinary(a: String, b: String): String {
        var i = a.lastIndex
        var j = b.lastIndex

        var carry = 0
        val sb = StringBuilder()
        while (i >= 0 && j >= 0) {
            val sum = (a[i] - '0') xor (b[j] - '0') xor carry
            carry = if (carry == 0) (a[i] - '0') and (b[j] - '0') else ((a[i] - '0') and 1) or ((b[j] - '0') and 1)
            sb.append(sum)

            i--
            j--
        }

        while (i >= 0) {
            val sum = (a[i] - '0') xor carry
            carry = (a[i] - '0') and carry
            sb.append(sum)

            i--
        }

        while (j >= 0) {
            val sum = (b[j] - '0') xor carry
            carry = (b[j] - '0') and carry
            sb.append(sum)

            j--
        }

        if (carry > 0) {
            sb.append(carry)
        }

        return sb.reverse().toString()
    }
}