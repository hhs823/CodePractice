import kotlin.math.sqrt

class Solution32 {
    var answer = 0
    fun solution(nums: IntArray): Int {
        for (i in 0..nums.size - 3)
            for (j in i + 1..nums.size - 2)
                for (k in j + 1 until nums.size) {
                    val num = nums[i] + nums[j] + nums[k]
                    if (isPrime(num)) answer++
                }

        return answer
    }

    private fun isPrime(num: Int): Boolean {
        if (num == 1) return false
        for (i in 2..sqrt(num.toDouble()).toInt()) {
            if (num % i == 0) return false
        }
        return true
    }
}