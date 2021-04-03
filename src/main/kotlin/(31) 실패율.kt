class Solution31 {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = intArrayOf()

        val count = Array(N + 2) { 0 }
        stages.forEach { count[it]++ }

        val sum = Array(N + 2) { 0 }
        sum[count.size - 1] = count.last()
        for (i in sum.size - 2 downTo 0) {
            sum[i] = count[i] + sum[i + 1]
        }

        return (1..N).map { if(count[it] == 0) it to 0.0 else it to 1.0 * count[it] / sum[it] }
            .sortedByDescending { it.second }.map { it.first }.toIntArray()
    }
}