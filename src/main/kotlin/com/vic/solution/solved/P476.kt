package com.vic.solution.solved

/**
 * 476. 数字的补数
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 *
 * 【示例 1】
 * 输入: 5
 * 输出: 2
 * 解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 *
 * 【示例 2】
 * 输入: 1
 * 输出: 0
 * 解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 *
 * 【注意】
 * 1. 给定的整数保证在 32 位带符号整数的范围内。
 * 2. 你可以假定二进制数不包含前导零位。
 * 3. 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P476 {
    fun findComplement(num: Int): Int {
        var x = num
        var i = 0
        repeat(31) {
            if (x and 1 == 1) {
                i = it
            }

            x = x shr 1
        }

        var mask = 1
        repeat(i) {
            mask = (mask shl 1) or 1
        }

        return (num xor mask) and 0x7FFFFFFF
    }
}