package com.vic.solution.solved

/**
 * 500. 键盘行
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。
 *
 * 【示例】
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 *
 * 【注意】
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P500 {
    fun findWords(words: Array<String>): Array<String> {
        val list = ArrayList<String>()

        val map = HashMap<Char, Int>()
        for (c in "QWERTYUIOP") {
            map[c] = 1
        }
        for (c in "ASDFGHJKL") {
            map[c] = 2
        }
        for (c in "ZXCVBNM") {
            map[c] = 3
        }

        for (s in words) {
            var row = -1
            var find = true
            for (c in s) {
                if (row == -1) {
                    row = map[c.toUpperCase()] ?: 0
                } else if (row != map[c.toUpperCase()]) {
                    find = false
                }
            }

            if (find) {
                list.add(s)
            }
        }

        return list.toTypedArray()
    }
}