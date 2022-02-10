package com.vic.solution.solved

/**
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 * 【示例】
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * 输出：
 * e
 * 解释：
 * 'e' 是那个被添加的字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P389 {
    fun findTheDifference(s: String, t: String): Char {
        val a = IntArray(26)

        for (c in s) {
            a[c - 'a']--
        }

        for (c in t) {
            a[c - 'a']++
        }

        for ((i, count) in a.withIndex()) {
            if (count == 1) {
                return 'a' + i
            }
        }

        return ' '
    }

    fun findTheDifference2(s: String, t: String): Char {
        var result = 0

        for (c in s) {
            result = result xor (c - 'a')
        }

        for (c in t) {
            result = result xor (c - 'a')
        }

        return 'a' + result
    }
}