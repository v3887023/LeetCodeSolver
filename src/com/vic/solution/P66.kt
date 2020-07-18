package com.vic.solution

/**
 * 66. 加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P66 {
    fun plusOne(digits: IntArray): IntArray {
        var carry = 1

        for (i in digits.size - 1 downTo 0) {
            val sum = digits[i] + carry

            digits[i] = sum % 10
            carry = sum / 10
        }

        return if (carry > 0) {
            val newDigits = IntArray(digits.size + 1)
            newDigits[0] = carry
            for (i in digits.indices) {
                newDigits[i + 1] = digits[i]
            }
            newDigits
        } else {
            digits
        }
    }
}