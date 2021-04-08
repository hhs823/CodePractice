class Solution39 {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val map = Array(N + 1) { Array(N + 1) { 987654321 } }
        for (i in 1..N) {
            map[i][i] = 0
        }
        road.forEach {
            if (map[it[0]][it[1]] > it[2]) {
                map[it[0]][it[1]] = it[2]
                map[it[1]][it[0]] = it[2]
            }
        }

        for (k in 1..N) {
            for (i in 1..N) {
                for (j in 1..N) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j]
                    }
                }
            }
        }

        return map[1].count { it <= k }
    }
}