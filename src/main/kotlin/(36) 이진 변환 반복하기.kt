class Solution36 {
    fun solution(s: String): IntArray {
        var count = 0
        var zero = 0
        var result = s

        while (result != "1") {
            var z = result.toCharArray().count { it == '0' }
            result = (result.length - z).toString(2)
            zero += z
            count++
        }

        return intArrayOf(count, zero)
    }
}