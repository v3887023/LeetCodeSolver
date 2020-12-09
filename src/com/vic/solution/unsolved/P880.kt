package com.vic.solution.unsolved

import com.vic.solution.println
import kotlin.math.min

/**
 * 880. 索引处的解码字符串
 * 给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤：
 * 1. 如果所读的字符是字母，则将该字母写在磁带上。
 * 2. 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
 *
 * 现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
 *
 * 【示例 1】
 * 输入：S = "leet2code3", K = 10
 * 输出："o"
 * 解释：
 * 解码后的字符串为 "leetleetcodeleetleetcodeleetleetcode"。字符串中的第 10 个字母是 "o"。
 *
 * 【示例 2】
 * 输入：S = "ha22", K = 5
 * 输出："h"
 * 解释：
 * 解码后的字符串为 "hahahaha"。第 5 个字母是 "h"。
 *
 * 【示例 3】
 * 输入：S = "a2345678999999999999999", K = 1
 * 输出："a"
 * 解释：
 * 解码后的字符串为 "a" 重复 8301530446056247680 次。第 1 个字母是 "a"。
 *
 * 【提示】
 * 1. 2 <= S.length <= 100
 * 2. S 只包含小写字母与数字 2 到 9 。
 * 3. S 以字母开头。
 * 4. 1 <= K <= 10^9
 * 5. 题目保证 K 小于或等于解码字符串的长度。
 * 6. 解码后的字符串保证少于 2^63 个字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decoded-string-at-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P880 {
    fun decodeAtIndex(S: String, K: Int): String {
        return ""
    }
}