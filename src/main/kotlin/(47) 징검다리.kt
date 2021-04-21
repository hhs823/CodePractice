class Solution47 {
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
            // 간격을 줄이고, n개를 넘지 않으면 간격을 늘리는 방식
            var removeCount = 0
            var prev = 0

            // 제거하는 돌의 개수를 구하는 과정
            rocks.forEach {
                if (it - prev < mid) {
                    removeCount++
                } else {
                    prev = it
                }
            }
            if (distance - prev < mid) removeCount++

            if (removeCount <= n) {
                answer = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return answer
    }
}