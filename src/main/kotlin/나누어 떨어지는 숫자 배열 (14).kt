class Solution14 {
    fun solution(arr: IntArray, divisor: Int): IntArray {
        val res = arr.filter { it % divisor == 0 }.sorted()
        return if(res.isEmpty()) intArrayOf(-1) else res.toIntArray()
    }
}