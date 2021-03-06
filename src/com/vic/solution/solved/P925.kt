package com.vic.solution.solved

/**
 * 925. 长按键入
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 * 【示例 1】
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 *
 * 【示例 2】
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 *
 * 【示例 3】
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 *
 * 【示例 4】
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 *
 * 【提示】
 * name.length <= 1000
 * typed.length <= 1000
 * name 和 typed 的字符都是小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/long-pressed-name
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P925 {
    fun isLongPressedName(name: String, typed: String): Boolean {
        var iLast = 0
        var jLast = 0
        var j = 0
        val length = typed.length

        // 注意不要漏了最后一个字符的判断
        for (i in 0..name.length) {
            // 当 i 超过 name 的字符数组的长度时，c 为 null
            val c = if (i < name.length) name[i] else null

            if (name[iLast] != c) {
                val count1 = i - iLast
                val lastC = name[iLast]
                while (j < length && typed[j] == lastC) {
                    j++
                }

                val count2 = j - jLast
                if (count2 < count1) {
                    return false
                }

                iLast = i
                jLast = j
            }
        }

        // 如果 j != length，说明，当 name 遍历结束后，j 还未遍历 typed 的全部字符，即 typed 末尾存在多余的字符
        return j == length
    }
}