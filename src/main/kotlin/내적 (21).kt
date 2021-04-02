class Solution21 {
    fun solution(a: IntArray, b: IntArray): Int {
        var answer = 0
        a.indices.forEach { answer += a[it] * b[it] }
        return answer
    }
}