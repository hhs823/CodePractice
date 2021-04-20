class Solution44 {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        val order = Array(n + 1) { Array(n + 1) { 98765432 } }
        results.forEach {
            order[it[0]][it[1]] = -1
            order[it[1]][it[0]] = 1
        }
        for (k in 1..n) {
            for (i in 1..n) {
                for (j in 1..n) {
                    if (order[i][k] == 1 && order[k][j] == 1) order[i][j] = 1
                    if (order[i][k] == -1 && order[k][j] == -1) order[i][j] = -1
                }
            }
        }
        loop@ for (i in 1..n) {
            for (j in 1..n) {
                if (i != j && order[i][j] == 98765432) continue@loop
            }
            answer++
        }
        return answer
    }
}