class Solution45 {
    private val dx = arrayOf(0, 1, 1, 1, 0, -1, -1, -1)
    private val dy = arrayOf(1, 1, 0, -1, -1, -1, 0, 1)

    fun solution(arrows: IntArray): Int {
        var answer = 0

        val nodeVisit = HashSet<Pos>()
        val edgeVisit = HashSet<Pair<Pos, Pos>>()

        var current = Pos(0, 0)
        nodeVisit.add(current)

        arrows.forEach {
            for (j in 1..2) {
                val dist = Pos(current.x + dx[it], current.y + dy[it])

                if (nodeVisit.contains(dist) && !edgeVisit.contains(Pair(current, dist))) {
                    edgeVisit.add(Pair(current, dist))
                    edgeVisit.add(Pair(dist, current))
                    answer++
                    current = dist
                    continue
                }

                nodeVisit.add(dist)
                edgeVisit.add(Pair(current, dist))
                edgeVisit.add(Pair(dist, current))
                current = dist
            }
        }

        return answer
    }

    data class Pos(val x: Int, val y: Int)
}