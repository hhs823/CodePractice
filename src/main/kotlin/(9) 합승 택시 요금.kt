class Solution9 {
    val INF = Int.MAX_VALUE / 3 - 1
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer: Int = INF

        val map = Array(n + 1) { i -> Array(n + 1) { j -> if (i == j) 0 else INF } }
        fares.forEach { map[it[0]][it[1]] = it[2]; map[it[1]][it[0]] = it[2] }

        for (k in 1..n) {
            for (i in 1..n) {
                for (j in 1..n) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j]
                    }
                }
            }
        }

        for (via in 1..n) {
            if (answer > map[s][via] + map[via][a] + map[via][b]) {
                answer = map[s][via] + map[via][a] + map[via][b]
            }
        }

        return answer
    }
}