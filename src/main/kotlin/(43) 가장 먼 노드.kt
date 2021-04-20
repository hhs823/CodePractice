import java.util.*

class Solution43 {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0

        val graph = Array(n + 1) { ArrayList<Int>() }

        edge.forEach {
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])
        }

        val res = graph.dijkstra()
        res[0] = -1
        val max = res.max()
        return res.count { it == max }
    }

    private fun Array<ArrayList<Int>>.dijkstra(): IntArray {
        val dist = Array(size) { 98765432 }
        val visit = Array(size) { false }

        val queue = ArrayDeque<Int>()
        queue.add(1)
        visit[1] = true
        dist[1] = 0
        while (queue.isNotEmpty()) {
            val now = queue.poll()
            this[now].forEach {
                if (!visit[it] && dist[it] > dist[now] + 1) {
                    visit[it] = true
                    dist[it] = dist[now] + 1
                    queue.add(it)
                }
            }
        }

        return dist.toIntArray()
    }
}
