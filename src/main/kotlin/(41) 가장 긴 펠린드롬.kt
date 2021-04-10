class Solution41 {
    fun solution(s: String): Int {
        var answer = 0

        for (i in s.indices) {
            loop@ for (j in s.length - 1 downTo i) {
                if (s[j] != s[i]) continue
                for (k in 1..(j - i + 1) / 2) {
                    if (s[i + k] != s[j - k]) continue@loop
                }
                if (answer < j - i + 1) answer = j - i + 1
            }
        }

        return answer
    }
}