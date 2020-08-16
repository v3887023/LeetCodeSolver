package com.vic.solution.solved

/**
 * 707. 设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。
 *
 * val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。
 *
 * 假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *   get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 *   addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 *   addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 *   addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
 *     如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 *   deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * 【提示】
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P707 {
    private class Node(var value: Int, var prev: Node? = null, var next: Node? = null)

    class MyLinkedList {
        /** Initialize your data structure here. */
        private var head: Node? = null
        private var tail: Node? = null
        private var length = 0

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        fun get(index: Int): Int {
            if (index in 0 until length) {
                return node(index).value
            }

            return -1
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        fun addAtHead(`val`: Int) {
            val oldHead = head
            val newNode = Node(`val`, null, oldHead)

            head = newNode

            if (oldHead == null) {
                tail = newNode
            } else {
                oldHead.prev = newNode
            }

            length++
        }

        /** Append a node of value val to the last element of the linked list. */
        fun addAtTail(`val`: Int) {
            val oldTail = tail
            val newNode = Node(`val`, oldTail, null)

            tail = newNode

            if (oldTail == null) {
                head = newNode
            } else {
                oldTail.next = newNode
            }

            length++
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        fun addAtIndex(index: Int, `val`: Int) {
            if (index == length) {
                return addAtTail(`val`)
                return
            }

            if (index in 0 until length) {
                val node = node(index)
                val prev = node.prev
                val newNode = Node(`val`, prev, node)

                node.prev = newNode

                if (prev == null) {
                    // 头结点
                    head = newNode
                } else {
                    prev.next = newNode
                }

                length++
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        fun deleteAtIndex(index: Int) {
            if (index in 0 until length) {
                val node = node(index)
                val prev = node.prev
                val next = node.next

                if (prev == null) {
                    // 头结点
                    head = next
                } else {
                    prev.next = next
                    node.prev = null
                }

                if (next == null) {
                    // 尾结点
                    tail = prev
                } else {
                    next.prev = prev
                    node.next = null
                }

                length--
            }
        }

        /**
         * index 必须有效
         */
        private fun node(index: Int): Node {
            var p: Node
            if (index < length.shr(1)) {
                p = head!!
                repeat(index) {
                    p = p.next!!
                }
            } else {
                p = tail!!
                repeat(length - 1 - index) {
                    p = p.prev!!
                }
            }

            return p
        }

        override fun toString(): String {
            val list = ArrayList<Int>()
            var p = head
            while (p != null) {
                list.add(p.value)
                p = p.next
            }

            return list.toString()
        }
    }

    class MyLinkedList2 {
        /** Initialize your data structure here. */
        private val head = Node(-1)
        private val tail = Node(-1)
        private var length = 0

        init {
            head.next = tail
            tail.prev = head
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        fun get(index: Int): Int {
            if (index in 0 until length) {
                return node(index).value
            }

            return -1
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        fun addAtHead(`val`: Int) {
            val next = head.next!!
            val newNode = Node(`val`, head, next)

            head.next = newNode
            next.prev = newNode

            length++
        }

        /** Append a node of value val to the last element of the linked list. */
        fun addAtTail(`val`: Int) {
            val prev = tail.prev!!
            val newNode = Node(`val`, prev, tail)

            prev.next = newNode
            tail.prev = newNode

            length++
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        fun addAtIndex(index: Int, `val`: Int) {
            if (index == length) {
                return addAtTail(`val`)
            }

            if (index in 0 until length) {
                val node = node(index)
                val prev = node.prev!!

                val newNode = Node(`val`, prev, node)
                prev.next = newNode
                node.prev = newNode

                length++
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        fun deleteAtIndex(index: Int) {
            if (index in 0 until length) {
                val node = node(index)
                val prev = node.prev!!
                val next = node.next!!

                prev.next = next
                next.prev = prev

                node.prev = null
                node.next = null

                length--
            }
        }

        /**
         * index 必须有效
         */
        private fun node(index: Int): Node {
            var p: Node
            if (index < length.shr(1)) {
                p = head.next!!
                repeat(index) {
                    p = p.next!!
                }
            } else {
                p = tail.prev!!
                repeat(length - 1 - index) {
                    p = p.prev!!
                }
            }

            return p
        }

        override fun toString(): String {
            val list = ArrayList<Int>()
            var p = head.next
            while (p != tail) {
                list.add(p!!.value)
                p = p.next
            }

            return list.toString()
        }
    }
}