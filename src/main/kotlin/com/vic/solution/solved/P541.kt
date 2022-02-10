package com.vic.solution.solved

/**
 * 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 【示例】
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 *
 * 【提示】
 * 该字符串只包含小写英文字母。
 * 给定字符串的长度和 k 在 [1, 10000] 范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P541 {
    fun reverseStr(s: String, k: Int): String {
        val chars = s.toCharArray()
        val length = s.length
        for (i in 0..s.lastIndex step k.shl(1)) {
            val count = length - i
            if (count < k) {
                chars.reverse(i, count)
            } else {
                chars.reverse(i, k)
            }
        }

        return String(chars)
    }

    private fun CharArray.reverse(start: Int, count: Int) {
        var i = start
        var j = start + count - 1

        while (i < j) {
            val temp = this[i]
            this[i++] = this[j]
            this[j--] = temp
        }
    }
}