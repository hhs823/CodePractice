import java.util.*

class Solution46 {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        var left = 1L
        var right = 1000000000000000000L

        while (left <= right) {
            val mid = (left + right) / 2
            var sum = 0L
            times.forEach {
                sum += mid / it
            }

            println("$mid $sum")

            if (n.toLong() <= sum) {
                answer = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return answer
    }
}