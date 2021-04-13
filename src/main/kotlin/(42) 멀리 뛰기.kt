import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.lang.StringBuilder

class Solution {
    fun solution(n: Int): Long {
        val dp = Array(n + 1) { 1L }
        for (i in 2..n) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567
        }

        return dp[n]
    }
}

fun main() {
    makeDeptJson()
}

@Serializable
data class Dept(val no: Int, val name: String, val location: String)

fun makeDeptJson() {
    val dept = Dept(1, "Marketing", "USA/Seattle")
    val deptJson = Json.encodeToString(dept)
    println(deptJson)
}