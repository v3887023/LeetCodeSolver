package com.vic.solution.solved

/**
 * 537. 复数乘法
 * 给定两个表示复数的字符串。
 * 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
 *
 * 【示例 1】
 * 输入: "1+1i", "1+1i"
 * 输出: "0+2i"
 * 解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 *
 * 【示例 2】
 * 输入: "1+-1i", "1+-1i"
 * 输出: "0+-2i"
 * 解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 *
 * 【注意】
 * 输入字符串不包含额外的空格。
 * 输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 100] 之间。输出也应当符合这种形式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/complex-number-multiplication
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P537 {
    fun complexNumberMultiply(a: String, b: String): String {
        val result = ComplexNumber.parse(a) * ComplexNumber.parse(b)
        return result.toString()
    }

    class ComplexNumber private constructor(private val real: Int, private val imaginary: Int) {

        companion object {
            fun parse(s: String): ComplexNumber {
                val split = s.split("+")
                val a = split[0].toInt()
                val b = split[1].substring(0, split[1].lastIndex).toInt()
                return ComplexNumber(a, b)
            }
        }

        operator fun times(another: ComplexNumber): ComplexNumber {
            val a = real * another.real - imaginary * another.imaginary
            val b = real * another.imaginary + another.real * imaginary
            return ComplexNumber(a, b)
        }

        override fun toString(): String {
            return "$real+${imaginary}i"
        }
    }
}