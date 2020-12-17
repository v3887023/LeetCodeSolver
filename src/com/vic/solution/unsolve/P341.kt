package com.vic.solution.unsolve

/**
 * 341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 * 【示例 1】
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 *
 * 【示例 2】
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P341 {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    class NestedInteger {
        // Constructor initializes an empty nested list.
        constructor()

        // Constructor initializes a single integer.
        constructor(value: Int)

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        fun isInteger(): Boolean = false

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        fun getInteger(): Int? = 0

        // Set this NestedInteger to hold a single integer.
        fun setInteger(value: Int): Unit {}

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        fun add(ni: NestedInteger): Unit {}

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        fun getList(): List<NestedInteger>? = emptyList()
    }

    class NestedIterator(nestedList: List<NestedInteger>) {
        fun next(): Int {
            return 0
        }

        fun hasNext(): Boolean {
            return false
        }
    }
}