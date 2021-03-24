import java.util.*

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0

        val init = Array(board.size) { Stack<Int>() }
        for (i in init.size - 1 downTo 0) {
            board[i].forEachIndexed { index, i -> if (i != 0) init[index].push(i) }
        }

        val stack = Stack<Int>()
        moves.forEach loop@{
            if (init[it - 1].isEmpty()) return@loop
            val pick = init[it - 1].pop()
            if (stack.isNotEmpty() && stack.peek() == pick) {
                stack.pop()
                answer += 2
            } else {
                stack.push(pick)
            }
        }

        return answer
    }
}