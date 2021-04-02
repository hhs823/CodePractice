class Solution11 {
    fun solution(words: Array<String>, queries: Array<String>): IntArray {
        var answer = intArrayOf()

        val trieArr1 = Array(10001) { Trie(Array(26) { null }) }
        val trieArr2 = Array(10001) { Trie(Array(26) { null }) }

        words.forEach {
            val len = it.length
            trieArr1[len].insert(it, 0)
            trieArr2[len].insert(it.reversed(), 0)
        }

        queries.forEach {
            val str = if (it[0] == '?') it.reversed() else it
            answer +=
                if (it[0] == '?') trieArr2[str.length].search(str, 0)
                else trieArr1[str.length].search(str, 0)
        }
        return answer
    }
}

class Trie(private val tries: Array<Trie?>) {
    var count = 0

    fun insert(p: String, index: Int) {
        if (index == p.length) return

        count++
        val next = p[index].toInt() - 'a'.toInt()
        if (tries[next] == null) {
            tries[next] = Trie(Array(26) { null })
        }
        tries[next]?.insert(p, index + 1)
    }

    fun search(p: String, index: Int): Int {
        if (index == p.length) return 1

        var result = 0
        result =
            if (p[index] == '?') count
            else {
                val next = p[index].toInt() - 'a'.toInt()
                tries[next]?.search(p, index + 1) ?: 0
            }

        return result
    }
}