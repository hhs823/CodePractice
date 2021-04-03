class Solution2 {
    fun solution2(a: Int, b: Int): String {
        val days = listOf("THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED")
        val lastDays = listOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

        val result = (0 until a - 1).map { lastDays[it] }.sum() + b

        return days[result % 7]
    }
}