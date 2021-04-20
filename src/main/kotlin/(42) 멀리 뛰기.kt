class Solution42 {
    fun solution(n: Int): Long {
        val dp = Array(n + 1) { 1L }
        for (i in 2..n) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567
        }

        return dp[n]
    }
}