class Solution26 {
    fun solution(n: Long): IntArray = n
        .toString().toCharArray()
        .reversedArray()
        .map { it.toInt() - '0'.toInt() }
        .toIntArray()
}