package com.vic.solution.solved

/**
 * 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 * 【示例】
 * 输入: "Hello World"
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P58 {
    fun lengthOfLastWord(s: String): Int {
        // 从字符串 s 末尾开始往前找第一个非空格字符的位置
        var index = s.length - 1
        while (index >= 0) {
            if (s[index] != ' ') {
                break
            }
            index--
        }

        // index != -1 表示字符串中有非空格字符，否则返回 0
        if (index != -1) {
            // 从字符串 index 位置开始往前找第一个空格字符的位置
            var spaceIndex = index - 1
            while (spaceIndex >= 0) {
                if (s[spaceIndex] == ' ') {
                    break
                }
                spaceIndex--
            }

            // spaceIndex == -1 表示字符串中 [0, index] 范围内没有空格字符，
            // 则最后一个单词长度即为 [0, index] 范围内字符的个数，即 index + 1
            // 否则，最后一个单词为 [spaceIndex + 1, index] 内的字符，其长度为 index - spaceIndex
            return if (spaceIndex == -1) index + 1 else index - spaceIndex
        }

        return 0
    }
}