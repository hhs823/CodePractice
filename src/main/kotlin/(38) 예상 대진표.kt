import kotlin.math.ceil

class Solution38{
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0

        var x = a
        var y = b

        while (true) {
            answer++
            x = ceil(x.toDouble() / 2).toInt()
            y = ceil(y.toDouble() / 2).toInt()

            println("$x $y")

            if(x == y) {
                break
            }
        }

        return answer
    }
}