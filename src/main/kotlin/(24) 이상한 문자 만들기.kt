class Solution24 {
    fun solution(s: String): String =
        s.split(" ").map {
            it.mapIndexed { index, c -> if(index % 2 == 0) c.toUpperCase() else c.toLowerCase() }.joinToString("")
        }.joinToString(" ")

}