class Solution48 {
    lateinit var parent: Array<Int>
    fun solution(n: Int, computers: Array<IntArray>): Int {
        parent = Array(n) { it }
        computers.indices.forEach { i ->
            (computers.indices).forEach { j ->
                if (computers[i][j] == 1) union(i, j)
            }
        }
        return parent.map { parent(it) }.toMutableSet().size
    }

    private fun union(a: Int, b: Int) {
        val pa = parent(a)
        val pb = parent(b)
        if (pa < pb) parent[pb] = pa
        else parent[pa] = pb
    }

    private fun parent(a: Int): Int {
        if (a == parent[a]) return a
        parent[a] = parent(parent[a])
        return parent[a]
    }
}