package com.vic.solution.unsolved

import com.vic.solution.println

/**
 * 722. 删除注释
 * （由于题目描述有点特殊，带有注释，显示会有异常，点击下面链接跳转查看吧）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-comments
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class P722 {
    fun removeComments(source: Array<String>): List<String> {
        val sb = StringBuilder()

        var state = STATE_NORMAL
        source.forEach { line ->
            var toProcess = line

            while (toProcess.isNotEmpty()) {
                when (state) {
                    STATE_NORMAL -> {
                        val lineCommentIndex = toProcess.indexOf("//")
                        val leftBlockCommentIndex = toProcess.indexOf("/*")
                        if (lineCommentIndex == -1 && leftBlockCommentIndex == -1) {
                            if (toProcess.isNotEmpty()) {
                                sb.append(toProcess).append(CHARACTER_NEW_LINE)
                            }
                            toProcess = ""
                        } else if (lineCommentIndex >= 0 && (lineCommentIndex < leftBlockCommentIndex || leftBlockCommentIndex == -1)) {
                            val toAppend = toProcess.subSequence(0, lineCommentIndex)
                            if (toAppend.isNotEmpty()) {
                                sb.append(toAppend).append(CHARACTER_NEW_LINE)
                            }
                            toProcess = ""
                        } else {
                            val toAppend = toProcess.subSequence(0, leftBlockCommentIndex)
                            if (toAppend.isNotEmpty()) {
                                sb.append(toAppend)
                            }
                            toProcess = toProcess.substring(leftBlockCommentIndex + 2)
                            state = STATE_FIND_RIGHT_BLOCK_COMMENT
                        }
                    }

                    STATE_FIND_RIGHT_BLOCK_COMMENT -> {
                        val rightBlockCommentIndex = toProcess.indexOf("*/")
                        toProcess = if (rightBlockCommentIndex == -1) {
                            ""
                        } else {
                            state = STATE_NORMAL
                            val startIndex = rightBlockCommentIndex + 2
                            if (startIndex in toProcess.indices) {
                                toProcess.substring(startIndex)
                            } else {
                                sb.append(CHARACTER_NEW_LINE)
                                ""
                            }
                        }
                    }
                }
            }
        }

        return sb.substring(0, sb.lastIndex).split(CHARACTER_NEW_LINE).filter { it.isNotEmpty() }.toList()
    }

    companion object {
        const val STATE_NORMAL = 0
        const val STATE_FIND_RIGHT_BLOCK_COMMENT = 1

        const val CHARACTER_NEW_LINE = '\n'
    }
}

fun main() {
//    val source = arrayOf("/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}")
//    val source = arrayOf("a/*comment", "line", "more_comment*/b")
//    val source = arrayOf("class test{", "public: ", "   int x = 1;", "   /*double y = 1;*/", "   char c;", "};")
//    val source = arrayOf("/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}")
//    val source = arrayOf("void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}")
    val source = arrayOf("/*123//*//**/241241")
    P722().removeComments(source).forEach { it.println() }
}