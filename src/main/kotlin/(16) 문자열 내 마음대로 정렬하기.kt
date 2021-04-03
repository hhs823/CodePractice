class Solution16 {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        return strings.sortedWith(Comparator { o1, o2 ->
            if (o1[n] != o2[n]) o1[n] - o2[n]
            else o1.compareTo(o2)
        }).toTypedArray()
    }
}