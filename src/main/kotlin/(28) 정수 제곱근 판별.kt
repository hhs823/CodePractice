import kotlin.math.sqrt

class Solution28 {
    fun solution(n: Long): Long {
        var root = sqrt(n.toDouble()).toLong()
        return if(root*root == n) (root + 1) * (root + 1) else -1
    }
}