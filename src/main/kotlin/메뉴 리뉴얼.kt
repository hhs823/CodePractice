class Solution {
    private val combs = mutableListOf<String>()
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val answer = mutableListOf<String>()
        val records = mutableMapOf<String, Int>()

        for (i in orders.indices) {
            for (j in course.indices) {
                if (orders[i].length < course[j]) break
                combs.clear()
                combination(orders[i].toCharArray().toList(), course[j], 0)
                combs.forEach { records[it] = records.getOrDefault(it, 0) + 1 }
            }
        }

        for (i in course.indices) {
            val temp = records.filter { it.key.length == course[i] && it.value > 1 }
            val most = temp.maxBy { it.value }?.value ?: continue
            answer.addAll(temp.filter { it.value >= most }.keys.toList())
        }
        return answer.sorted().toTypedArray()
    }

    private fun combination(chars: List<Char>, r: Int, index: Int, temp: String = "") {
        if (temp.length == r) combs.add(temp)

        var tmp = temp
        for (i in index until chars.size) {
            tmp += chars[i]
            combination(chars, r, i + 1, tmp)
            tmp = tmp.substring(0, tmp.length - 1)
        }
    }
}