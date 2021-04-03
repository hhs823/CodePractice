class Solution18 {
    fun solution(s: String): Boolean
        = s.all { it.isDigit() } && (s.length == 4 || s.length == 6)
}