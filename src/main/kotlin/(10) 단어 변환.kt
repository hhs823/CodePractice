class Solution10 {
    var answer = 0
    fun solution(begin: String, target: String, words: Array<String>): Int {
        answer = words.size + 1

        dfs(words, 0, begin, target)

        return if (answer == words.size + 1) 0 else answer
    }

    fun dfs(words: Array<String>, count: Int, res: String, target: String) {
        if (count > answer) return
        if (res == target) {
            if (count < answer) answer = count
            return
        }

        words.filter {
            var cnt = 0
            it.forEachIndexed { index, c ->
                if (c != res[index]) cnt++
            }
            cnt == 1
        }.forEach { dfs(words, count + 1, it, target) }
    }
}