import java.lang.StringBuilder
import kotlin.math.min

class Solution1 {
    fun solution1(s: String): Int {
        var answer = s.length

        for(i in 1..s.length / 2) {
            answer = min(answer, compress(s, i))
        }

        return answer
    }

    private fun compress(s: String, size: Int): Int {
        val result = StringBuilder()

        var split = ArrayList<String>()

        var word = StringBuilder()
        s.split("").filter { it.isNotEmpty() }.forEach {
            word.append(it)
            if (word.length == size) {
                split.add(word.toString())
                word = StringBuilder()
            }
        }
        if(word.isNotEmpty())
            split.add(word.toString())

        var cnt = 1
        var prev = split[0]

        for (i in 1 until split.size) {
            if (split[i] == prev) cnt++
            else {
                if(cnt != 1)
                    result.append(cnt).append(prev)
                else
                    result.append(prev)
                prev = split[i]
                cnt = 1
            }
        }
        if(cnt != 1)
            result.append(cnt).append(prev)
        else
            result.append(prev)

        return result.toString().length
    }
}