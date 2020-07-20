package com.vic.solution.solved

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 【示例 1】
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 【示例 2】
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P125 {
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.lastIndex

        while (true) {
            while (i < s.length && !isValidChar(s[i])) {
                i++
            }

            while (j >= 0 && !isValidChar(s[j])) {
                j--
            }

            if (i > j) {
                break
            } else {
                if (isSameChar(s[i], s[j])) {
                    i++
                    j--
                } else {
                    return false
                }
            }
        }

        return true
    }

    fun isPalindrome2(s: String): Boolean {
        var i = 0
        var j = s.lastIndex

        while (i < j) {
            val c1 = s[i].toLowerCase()
            if (!isValidChar(c1)) {
                i++
                continue
            }

            val c2 = s[j].toLowerCase()
            if (!isValidChar(c2)) {
                j--
                continue
            }

            if (c1 != c2) {
                return false
            }

            i++
            j--
        }

        return true
    }

    private fun isValidChar(c: Char): Boolean {
        return c in 'a'..'z' || c in '0'..'9'
    }

    private fun isSameChar(c1: Char, c2: Char): Boolean {
        return Character.toLowerCase(c1.toInt()) == Character.toLowerCase(c2.toInt())
    }
}