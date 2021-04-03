class Solution33 {
    fun solution(n: Int, m: Int): IntArray = intArrayOf(gcd(n, m), n * m / gcd(n, m))

    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}