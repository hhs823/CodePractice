class Solution5 {
    fun solution(a: IntArray): Int {
        if (a.size <= 2) return a.size

        var answer: Int = 2
        var left = 0
        var right = a.size - 1

        var leftmin = a[left]
        var rightmin = a[right]

        var count = 0
        while (count < a.size - 2) {
            if (leftmin < rightmin) {
                right--
                if (a[right] <= rightmin) {
                    answer++
                    rightmin = a[right]
                }
            } else {
                left++
                if (a[left] <= leftmin) {
                    answer++
                    leftmin = a[left]
                }
            }
            count++
        }
        return answer
    }
}