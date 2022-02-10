package com.vic.solution.solved

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 【示例 1】
 * 输入: "hello"
 * 输出: "holle"
 *
 * 【示例 2】
 * 输入: "leetcode"
 * 输出: "leotcede"
 *
 * 【说明】
 * 元音字母不包含字母"y"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P345 {
    fun reverseVowels(s: String): String {
        val a = s.toCharArray()

        var i = 0
        var j = s.lastIndex
        while (i < j) {
            val c1 = a[i].toLowerCase()
            if (!isVowel(c1)) {
                i++
                continue
            }

            val c2 = a[j].toLowerCase()
            if (!isVowel(c2)) {
                j--
                continue
            }

            val temp = a[i]
            a[i++] = a[j]
            a[j--] = temp
        }

        return String(a)
    }

    private fun isVowel(c: Char): Boolean {
        return when (c) {
            'a', 'e', 'i', 'o', 'u' -> true
            else -> false
        }
    }
}