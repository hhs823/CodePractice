import java.lang.StringBuilder
import java.util.*

class Solution4 {
    fun solution(p: String): String {
        if (p.isEmpty()) return ""

        var (open, close) = listOf(0, 0)
        var idx = 0

        for (i in p.indices) {
            if (p[i] == '(') open++
            else close++

            if (open == close) break
            idx++
        }

        var u = p.substring(0, idx + 1)
        var v = p.substring(idx + 1)

        return if (isCorrect(u)) {
            u + solution(v)
        } else {
            "(" + solution(v) + ")" + rev(u)
        }
    }

    private fun rev(u: String): Any? {
        val rest = u.substring(1, u.length - 1)
        val result = StringBuilder()
        for (i in rest.indices) {
            if(rest[i] == '(') result.append(')')
            else result.append('(')
        }
        return result.toString()
    }

    private fun isCorrect(u: String): Boolean {
        val stack = Stack<Char>()
        for (i in u.indices) {
            when (u[i]) {
                '(' -> stack.push(u[i])
                else -> {
                    if (stack.isEmpty()) return false
                    else stack.pop()
                }
            }
        }
        return true
    }
}