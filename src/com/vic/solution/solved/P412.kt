package com.vic.solution.solved

/**
 * 412. Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 【示例】
 * n = 15,
 * 返回:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P412 {
    fun fizzBuzz(n: Int): List<String> {
        val list = ArrayList<String>()

        for (i in 1..n) {
            when {
                i % 15 == 0 -> list.add("FizzBuzz")
                i % 3 == 0 -> list.add("Fizz")
                i % 5 == 0 -> list.add("Buzz")
                else -> list.add(i.toString(10))
            }
        }

        return list
    }

    fun fizzBuzz2(n: Int): List<String> {
        val list = ArrayList<String>()

        for (i in 1..n) {
            list.add(if (i % 3 == 0) {
                if (i % 5 == 0) {
                    "FizzBuzz"
                } else {
                    "Fizz"
                }
            } else if (i % 5 == 0) {
                "Buzz"
            } else {
                "$i"
            })
        }

        return list
    }

    fun fizzBuzz3(n: Int): List<String> {
        val list = ArrayList<String>()

        for (i in 1..n) {
            list.add(when {
                i % 3 == 0 -> if (i % 5 == 0) "FizzBuzz" else "Fizz"
                i % 5 == 0 -> "Buzz"
                else -> "$i"
            })
        }

        return list
    }
}