class Solution49 {
    val SRC = 0
    val DST = 1

    val answer = ArrayList<String>()
    var route = ""
    private lateinit var visited: Array<Boolean>

    fun solution(tickets: Array<Array<String>>): Array<String> {
        for (i in tickets.indices) {
            visited = Array(tickets.size) { false }
            val src = tickets[i][SRC]
            val dst = tickets[i][DST]

            if (src == "ICN") {
                route = "$src,"
                visited[i] = true
                dfs(tickets, dst, 1)
            }
        }
        answer.sort()
        return answer[0].split(",").filter { it.isNotBlank() }.toTypedArray()
    }

    fun dfs(tickets: Array<Array<String>>, dst: String, visitCount: Int) {
        route += "$dst,"

        if (visitCount == tickets.size) {
            answer.add(route)
            return
        }

        for (i in tickets.indices) {
            val nextSrc = tickets[i][SRC]
            val nextDst = tickets[i][DST]
            if (nextSrc == dst && !visited[i]) {
                visited[i] = true
                dfs(tickets, nextDst, visitCount + 1)
                visited[i] = false
                route = route.substring(0, route.length - 4)
            }
        }
    }
}