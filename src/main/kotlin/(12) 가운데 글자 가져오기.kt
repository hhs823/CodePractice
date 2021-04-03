class Solution12 {
    fun solution(s: String): String =
        if (s.length % 2 == 0) s.slice(s.length / 2 - 1..s.length / 2)
        else s[s.length / 2].toString()
}