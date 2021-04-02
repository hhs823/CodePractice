class Solution20 {
    fun solution(n: Int): String {
        var answer = ""
        val word = listOf("수", "박")
        for (i in 0 until n) {
            answer += word[i % 2]
        }
        return answer
    }
}