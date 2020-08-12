package com.vic.solution.solved

/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 【示例 1】
 * 输入: "III"
 * 输出: 3
 *
 * 【示例 2】
 * 输入: "IV"
 * 输出: 4
 *
 * 【示例 3】
 * 输入: "IX"
 * 输出: 9
 *
 * 【示例 4】
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * 【示例 5】
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P13 {
    fun romanToInt(s: String): Int {
        val map = mapOf("I" to 1, "IV" to 4, "V" to 5, "IX" to 9, "X" to 10, "XL" to 40, "L" to 50,
                "XC" to 90, "C" to 100, "CD" to 400, "D" to 500, "CM" to 900, "M" to 1000)

        var result = 0
        var i = s.lastIndex
        while (i >= 0) {
            if (i > 0) {
                val s2 = s.substring(i - 1, i + 1)
                var value = map.getOrDefault(s2, 0)
                if (value == 0) {
                    value = map[s[i].toString()] ?: 0
                } else {
                    i--
                }
                result += value
            } else {
                result += map[s[i].toString()] ?: 0
            }
            i--
        }

        return result
    }

    fun romanToInt2(s: String): Int {
        val map = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

        var result = 0
        var lastValue = map[s[0]] ?: 0
        for (i in 1 until s.length) {
            val value = map[s[i]] ?: 0
            if (lastValue < value) {
                result -= lastValue
            } else {
                result += lastValue
            }

            lastValue = value
        }

        result += lastValue

        return result
    }
}