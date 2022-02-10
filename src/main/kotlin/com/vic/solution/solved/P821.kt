package com.vic.solution.solved

import java.util.*
import kotlin.math.abs
import kotlin.math.min

/**
 * 821. 字符的最短距离
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 *
 * 【示例】
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 * 【说明】
 * 字符串 S 的长度范围为 [1, 10000]。
 * C 是一个单字符，且保证是字符串 S 里的字符。
 * S 和 C 中的所有字母均为小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P821 {
    fun shortestToChar(S: String, C: Char): IntArray {
        val length = S.length
        val a = IntArray(length)
        val stack = LinkedList<Int>()
        var lastIndex = -1

        for ((i, c) in S.withIndex()) {
            if (c == C) {
                a[i] = 0
                while (stack.isNotEmpty()) {
                    val index = stack.pop()
                    if (lastIndex < 0) {
                        a[index] = abs(index - i)
                    } else {
                        a[index] = min(abs(index - i), abs(index - lastIndex))
                    }
                }
                lastIndex = i
            } else {
                stack.push(i)
            }
        }

        while (stack.isNotEmpty()) {
            val index = stack.pop()
            a[index] = abs(index - lastIndex)
        }

        return a
    }
}