class Solution15 {
    fun solution(a: Int, b: Int): Long {
        return if (a < b) {
            (a.toLong()..b.toLong()).sum()
        } else {
            (b.toLong()..a.toLong()).sum()
        }
    }
}