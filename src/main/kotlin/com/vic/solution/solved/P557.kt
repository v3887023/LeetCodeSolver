package com.vic.solution.solved

/**
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 【示例】
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * 【提示】
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P557 {
    fun reverseWords(s: String): String {
        val charArray = s.toCharArray()

        var lastLetterIndex = 0
        for ((i, c) in charArray.withIndex()) {
            if (c == ' ') {
                charArray.reverse(lastLetterIndex, i)
                lastLetterIndex = i + 1
            }
        }

        charArray.reverse(lastLetterIndex, charArray.size)

        return String(charArray)
    }

    /**
     * 将字符数组中 [start, endExclusive) 范围内的字符反转
     */
    fun CharArray.reverse(start: Int = 0, endExclusive: Int = size) {
        var i = start
        var j = endExclusive - 1
        while (i < j) {
            val temp = this[i]
            this[i++] = this[j]
            this[j--] = temp
        }
    }
}