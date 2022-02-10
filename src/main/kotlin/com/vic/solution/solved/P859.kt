package com.vic.solution.solved

/**
 * 859. 亲密字符串
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 * 【示例 1】
 * 输入： A = "ab", B = "ba"
 * 输出： true
 *
 * 【示例 2】
 * 输入： A = "ab", B = "ab"
 * 输出： false
 *
 * 【示例 3】
 * 输入： A = "aa", B = "aa"
 * 输出： true
 *
 * 【示例 4】
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 *
 * 【示例 5】
 * 输入： A = "", B = "aa"
 * 输出： false
 *
 * 【提示】
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P859 {
    fun buddyStrings(A: String, B: String): Boolean {
        if (A.length != B.length) {
            return false
        }

        val map = IntArray(26) { 0 }
        var diffCount = 0
        var firstDiff: Char? = null
        var secondDiff: Char? = null
        var findDiff = false
        var hasTwoSameLetter = false
        for (i in A.indices) {
            val c1 = A[i]
            val c2 = B[i]
            if (c1 != c2) {
                if (findDiff) {
                    if (c1 != secondDiff || c2 != firstDiff) {
                        return false
                    }
                } else {
                    firstDiff = c1
                    secondDiff = c2
                    findDiff = true
                }
                diffCount++
            }
            map[c1 - 'a']++
            if (map[c1 - 'a'] > 1) {
                hasTwoSameLetter = true
            }
        }

        return diffCount == 2 || diffCount == 0 && hasTwoSameLetter
    }
}