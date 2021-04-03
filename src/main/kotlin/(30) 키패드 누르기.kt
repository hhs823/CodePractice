import kotlin.math.abs

class Solution30 {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""

        val hm = HashMap<String, Pair<Int, Int>>()
        hm["0"] = Pair(0, 0)
        hm["1"] = Pair(-1, 3)
        hm["2"] = Pair(0, 3)
        hm["3"] = Pair(1, 3)
        hm["4"] = Pair(-1, 2)
        hm["5"] = Pair(0, 2)
        hm["6"] = Pair(1, 2)
        hm["7"] = Pair(-1, 1)
        hm["8"] = Pair(0, 1)
        hm["9"] = Pair(1, 1)
        hm["*"] = Pair(-1, 0)
        hm["#"] = Pair(1, 0)

        var left = hm["*"]
        var right = hm["#"]

        numbers.map { it.toString() }.forEach {
            when (it) {
                "1", "4", "7" -> {
                    answer += "L"
                    left = hm[it]
                }
                "3", "6", "9" -> {
                    answer += "R"
                    right = hm[it]
                }
                else -> {
                    val dl = dist(hm[it]!!, left!!)
                    val dr = dist(hm[it]!!, right!!)
                    when {
                        dl < dr -> { answer += "L"; left = hm[it] }
                        dl > dr -> { answer += "R"; right = hm[it] }
                        else -> {
                            if (hand == "left") { answer += "L"; left = hm[it] }
                            else { answer += "R"; right = hm[it] }
                        }
                    }
                }
            }
        }

        return answer
    }

    fun dist(right: Pair<Int, Int>, left: Pair<Int, Int>): Int =
        abs(right.first - left.first) + abs(right.second - left.second)

}

fun main() {
    var (a, b) = readLine()!!.split(' ').map(String::toInt)
    val sb = StringBuilder()
    while(b-- > 0) {
        sb.append(String(CharArray(a){'*'})).append("\n")
    }
    println(sb.toString())
}