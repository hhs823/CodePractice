class Solution35 {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()

        val list = s.removePrefix("{").removeSuffix("}")
            .replace("},{", "} {").split(" ")
            .sortedBy { it.length }
            .map {
                it.removePrefix("{").removeSuffix("}").split(",").map { it.toInt() }
            }

        list.indices.forEach {
            if (it == 0) answer += list[it][0]
            else {
                val hm = HashMap<Int, Int>()
                list[it - 1].forEach { hm[it] = hm.getOrDefault(it, 0) + 1 }
                list[it].forEach {
                    if (!hm.containsKey(it) || hm[it] == 0) answer += it
                    else hm[it] = hm[it]!! - 1
                }
            }
        }

        return answer
    }

    fun sol(s: String): IntArray =
        s.substring(2 until s.length - 2)
            .split("},{")
            .asSequence()
            .map { it.split(",").map { num -> num.toInt() } }
            .toList()
            .sortedBy { it.size }
            .fold(setOf<Int>()) { acc, list -> acc.union(list) }
            .toIntArray()

}

fun main() {
    println()
}