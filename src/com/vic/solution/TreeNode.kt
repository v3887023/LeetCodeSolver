package com.vic.solution

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        fun createTree(string: String = ""): TreeNode? {
            val split = string.replace(" ", "").split(",")

            val size = split.size
            if (size == 0) {
                return null
            }

            val queue = LinkedList<TreeNode>()

            val root = createTreeNode(split[0])
            root?.let { queue.offer(it) }

            var i = 1
            while (queue.isNotEmpty()) {
                val node = queue.pop()

                if (i < size) {
                    val left = createTreeNode(split[i++])
                    left?.let {
                        node.left = it
                        queue.offer(it)
                    }
                }

                if (i < size) {
                    val right = createTreeNode(split[i++])
                    right?.let {
                        node.right = it
                        queue.offer(it)
                    }
                }
            }

            return root
        }

        private fun createTreeNode(s: String): TreeNode? {
            if (s == "null") {
                return null
            }

            try {
                val value = s.toInt()
                return TreeNode(value)
            } catch (e: NumberFormatException) {
                throw IllegalArgumentException("$s is not a legal String to create a tree")
            }
        }
    }
}