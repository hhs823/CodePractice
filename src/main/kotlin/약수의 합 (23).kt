import kotlin.math.sqrt

class Solution23 {
    fun solution(n: Int): Int {
        var answer = 0
        for (i in 1..sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) {
                answer += i
                if (i * i != n) answer += n / i
            }
        }
        return answer
    }
}