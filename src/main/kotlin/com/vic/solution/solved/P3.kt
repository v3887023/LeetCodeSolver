package com.vic.solution.solved

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 【示例 1】
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 【示例 2】
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 【示例 3】
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P3 {
    fun lengthOfLongestSubstring(s: String): Int {
        val length = s.length
        if (length < 2) {
            return length
        }
        val set: MutableSet<Char> = HashSet()
        var max = 1
        var len: Int
        for (i in 0 until length) {
            len = 0
            set.clear()
            for (j in i until length) {
                val c = s[j]
                len++
                if (!set.add(c)) {
                    len--
                    break
                }
            }
            if (len > max) {
                max = len
            }
        }
        return max
    }
}