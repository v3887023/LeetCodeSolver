package com.vic.solution.solved

/**
 * 706. 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射
 *
 * 具体地说，你的设计应该包含以下的功能
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 *
 * 示例：
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);        
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 *
 * 注意：
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P706 {
    /** Initialize your data structure here. */
    val table = Array<Node?>(64) { null }

    inner class Node(val key: Int, var value: Int) {
        var next: Node? = null
    }

    private fun Int.hash(): Int {
        val hash = hashCode()
        return hash.shr(16) xor hash
    }

    /** value will always be non-negative. */
    fun put(key: Int, value: Int) {
        val i = (table.size - 1) and key.hash()
        val node = table[i]

        if (node == null) {
            table[i] = Node(key, value)
        } else {
            var p = node
            while (p != null) {
                if (p.key == key) {
                    p.value = value
                    return
                }
                p = p.next
            }

            val newNode = Node(key, value)
            newNode.next = node.next
            node.next = newNode
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    fun get(key: Int): Int {
        val node = table[(table.size - 1) and key.hash()]

        if (node != null) {
            var p = node
            while (p != null) {
                if (p.key == key) {
                    return p.value
                }

                p = p.next
            }
        }

        return -1
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    fun remove(key: Int) {
        val i = (table.size - 1) and key.hash()
        val node = table[i]

        if (node != null) {
            var p = node
            var pre: Node? = null
            while (p != null) {
                if (p.key == key) {
                    if (pre == null) {
                        table[i] = node.next
                        node.next = null
                    } else {
                        if (p.next == null) {
                            pre.next = null
                        } else {
                            pre.next = p.next
                            p.next = null
                        }
                    }
                    break
                }
                pre = p
                p = p.next
            }
        }
    }
}