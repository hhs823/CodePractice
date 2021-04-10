import java.lang.StringBuilder

class Solution {
    fun solution(n: Int): Long {
        val dp = Array(n + 1) { 1L }
        for (i in 2..n) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567
        }

        return dp[n]
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val sum = arrayListOf(0, arr[0])
    (1 until arr.size).forEach { sum.add(sum[it] + arr[it]) }

    val sb = StringBuilder()
    repeat(m) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        sb.append(sum[j] - sum[i-1]).append("\n")
    }

    print(sb.toString())
}