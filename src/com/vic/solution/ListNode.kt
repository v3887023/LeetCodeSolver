package com.vic.solution

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    companion object {
        fun newList(vararg nums: Int): ListNode? {
            val head = ListNode(-1)

            var p: ListNode = head
            for (n in nums) {
                val node = ListNode(n)
                p.next = node
                p = p.next!!
            }

            return head.next
        }
    }

}