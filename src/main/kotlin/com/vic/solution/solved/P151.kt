package com.vic.solution.solved

/**
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 进阶：
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P151 {
    fun reverseWords(s: String): String {
        val charArray = s.toCharArray()

        /*
        * 先去掉字符串前后多余的空格，并且使单词间只有一个空格
        * */

        var j = 0
        // 原字符数组中空格字符的索引
        var lastSpaceIndex = -1
        // 去掉多余空格后的字符数组中最后一个非空格字符的索引
        var lastLetterIndex = -1
        for ((i, c) in charArray.withIndex()) {
            if (c == ' ') {
                // 已找到第一个非空格字符并且没有两个空格连续时，保留该空格
                if (lastLetterIndex >= 0 && i - lastSpaceIndex > 1) {
                    charArray[j++] = c
                }

                lastSpaceIndex = i
            } else {
                // 非空格字符直接保留
                lastLetterIndex = j
                charArray[j++] = c
            }
        }

        // 去掉多余空格后字符数组的长度，即最后得到的字符串的长度
        val length = lastLetterIndex + 1

        // 反转字符数组
        charArray.reverse(0, length)

        var lastIndex = 0
        for (i in 0 until length) {
            if (charArray[i] == ' ') {
                charArray.reverse(lastIndex, i)
                lastIndex = i + 1
            }
        }

        charArray.reverse(lastIndex, length)

        return String(charArray, 0, length)
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