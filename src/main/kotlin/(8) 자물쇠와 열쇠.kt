class Solution8 {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        var answer = true

        val map = Array(lock.size + key.size - 1) { Array(lock.size + key.size - 1) { 0 } }
        for (i in lock.indices) {
            for (j in lock[i].indices) {
                map[i + key.size - 1][j + key.size - 1] = lock[i][j]
            }
        }

        for (i in 0..3) {
            val rotatedKey = rotate(key)

        }

        return answer
    }

    private fun isFit(arr: Array<IntArray>, size: Int): Boolean {
        val pad = (arr.size - size) / 2
        val len = arr.size - 2 * pad

        for (i in 0 until len) {
            for (j in 0 until len) {
                if (arr[pad + i][pad + j] == 0) return false
            }
        }
        return true
    }

    private fun rotate(arr: Array<IntArray>): Array<IntArray> {
        val size = arr.size
        val res = Array(size) { IntArray(size) { 0 } }

        for (i in res.indices) {
            for (j in res[i].indices) {
                res[i][j] = arr[size - 1 - j][i]
            }
        }

        return res
    }
}