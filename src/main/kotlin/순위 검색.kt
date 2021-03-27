import java.util.*
import kotlin.collections.ArrayList

class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray = Prob3(info, query).solve()

}

class Prob3(infos: Array<String>, queries: Array<String>) {
    var infoMap: MutableMap<Int, ArrayList<Int>> = HashMap()
    lateinit var queries: Array<IntArray>
    private fun saveInfo(infos: Array<String>) {
        for (info in infos) {
            val infoSplit = info.split(" ".toRegex()).toTypedArray()
            val hash = Hash.createHash(infoSplit)
            val score = infoSplit[4].toInt()
            addNewInfo(hash, score)
        }
    }

    private fun addNewInfo(hash: Int, score: Int) {
        if (!infoMap.containsKey(hash)) {
            object : ArrayList<Int>() {
                init {
                    add(score)
                }
            }.also { infoMap[hash] = it }
        } else {
            val scoreArr = infoMap[hash]!!
            var idx = Collections.binarySearch(scoreArr, score)
            if (idx < 0) idx = -idx - 1
            scoreArr.add(idx, score)
        }
    }

    private fun saveQuery(queries: Array<String>) {
        var cnt = 0
        this.queries = Array(queries.size) { IntArray(2) }
        for (query in queries) {
            val splitQuery = query.split("( and )| ".toRegex()).toTypedArray()
            this.queries[cnt][0] = Hash.createZeroHash(splitQuery)
            this.queries[cnt++][1] = splitQuery[4].toInt()
        }
    }

    fun solve(): IntArray {
        val queryResult = IntArray(queries.size)
        for (i in queries.indices) queryResult[i] = counter(queries[i][0], queries[i][1])
        return queryResult
    }

    private fun counter(zeroHash: Int, targetScore: Int): Int {
        var cnt = 0
        val hashCombination = Hash.combineZeroHash(zeroHash)
        for (hash in hashCombination) {
            val scoreArr = infoMap[hash] ?: continue
            val lowerCount = lowerBound(scoreArr, targetScore)
            cnt += scoreArr.size - lowerCount
        }
        return cnt
    }

    private fun lowerBound(list: List<Int>, key: Int): Int {
        var low = 0
        var high = list.size
        while (low < high) {
            val mid = low + (high - low) / 2
            if (key <= list[mid]) high = mid else low = mid + 1
        }
        return low
    }

    private object Hash {
        fun createHash(split: Array<String>): Int =
            Language.valueOf(split[0]).ordinal * 1000 +
                    Apply.valueOf(split[1]).ordinal * 100 +
                    Career.valueOf(split[2]).ordinal * 10 +
                    SoulFood.valueOf(split[3]).ordinal

        fun createZeroHash(split: Array<String>): Int {
            for (i in split.indices) if (split[i] == "-") split[i] = "none"
            return createHash(split)
        }

        fun combineZeroHash(hash: Int): Array<Int> {
            val list = ArrayList<Int>()
            recursion(hash, list)
            return list.toTypedArray()
        }

        private fun recursion(hash: Int, save: ArrayList<Int>) {
            val hashString = String.format("%04d", hash)
            val language = Character.getNumericValue(hashString[0])
            val apply = Character.getNumericValue(hashString[1])
            val career = Character.getNumericValue(hashString[2])
            val soulFood = Character.getNumericValue(hashString[3])

            when {
                language == 0 -> for (i in 1..3) recursion(hash + i * 1000, save)
                apply == 0 -> for (i in 1..2) recursion(hash + i * 100, save)
                career == 0 -> for (i in 1..2) recursion(hash + i * 10, save)
                soulFood == 0 -> for (i in 1..2) recursion(hash + i, save)
                else -> {
                    save.add(hash)
                    return
                }
            }
        }
    }

    init {
        saveInfo(infos)
        saveQuery(queries)
    }
}

internal enum class Language {
    none, cpp, java, python
}

internal enum class Apply {
    none, backend, frontend
}

internal enum class Career {
    none, junior, senior
}

internal enum class SoulFood {
    none, chicken, pizza
}