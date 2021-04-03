class Solution27 {
    fun solution(n: Long): Long = n
        .toString().split("")
        .filter { it.isNotEmpty() }
        .sortedDescending()
        .joinToString("").toLong()
}