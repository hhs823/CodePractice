import java.util.*
import kotlin.math.abs

class Solution {
    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        // rocks를 정렬
        rocks.sort()
        // 최소간격을 1에서 distance까지 고려
        var left = 1
        var right = distance

        var answer = 0

        while (left <= right) {
            val mid = (left + right) / 2

            // 만약 간격을 mid로 맞추기 위해 제거해야 하는 돌의 개수가 n개를 넘으면
            // 간격을 줄여야

        }

        return answer
    }
}