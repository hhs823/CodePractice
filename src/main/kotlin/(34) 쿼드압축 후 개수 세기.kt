class Solution34 {
    val answer = intArrayOf(0, 0)
    lateinit var map: Array<IntArray>

    fun solution(arr: Array<IntArray>): IntArray {
        map = Array(arr.size) { arr[it] }

        count(0, 0, arr.size)

        return answer
    }

    fun count(x: Int, y: Int, size: Int) {
        var flag = true
        val value = map[x][y]

        loop@for (i in x until x + size) {
            for (j in y until y + size) {
                if(map[i][j] != value) {
                    flag = false
                    break@loop
                }
            }
        }

        if(flag){
            answer[value]++
            return
        }

        count(x, y, size / 2)
        count(x, y + size / 2, size / 2)
        count(x + size / 2, y, size / 2)
        count(x + size / 2, y + size / 2, size / 2)
    }
}