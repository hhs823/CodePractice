class Solution25 {
    fun solution(n: Int): Int {
        var answer = 0
        var t = n
        while(t > 0) {
            answer += t % 10
            t /= 10
        }
        return answer
    }
}