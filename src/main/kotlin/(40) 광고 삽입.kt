class Solution40 {
    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
        var answer = "00:00:00"
        val play = convertTime(play_time)
        val adv = convertTime(adv_time)

        val logTime = logs.map {
            val list = it.split("-")
            Time(convertTime(list[0]), convertTime(list[1]))
        }.sortedBy { it.start }

        var max = logTime.filter { contain(0, adv, it.start, it.end) }.sumBy { adTime(0, adv, it.start, it.end) }

        println(max)

        logTime.forEach { st ->
            val sol = logTime.filter { contain(st.start, st.start + adv, it.start, it.end) }.sumBy {
                println("start: ${convertString(it.start)}, end: ${convertString(it.end)}")
                if (st.start + adv > 100 * 3600 - 1)
                    adTime(st.start, 100*3600 - 1, it.start, it.end)
                else
                   adTime(st.start, st.start + adv, it.start, it.end)
            }
            if (sol > max) {
                max = sol
                answer = convertString(st.start)
                println(answer + " ::" + sol)
            }
        }
        return answer
    }

    fun contain(adStart: Int, adEnd: Int, logStart: Int, logEnd: Int): Boolean =
        when {
            adEnd < logStart -> false
            logEnd < adStart -> false
            else -> true
        }

    fun adTime(adStart: Int, adEnd: Int, logStart: Int, logEnd: Int): Int =
        when {
            adEnd < logStart -> 0
            logEnd < adStart -> 0
            adStart <= logStart && logEnd <= adEnd -> logEnd - logStart
            adStart <= logStart -> adEnd - logStart
            logStart <= adStart && logEnd <= adEnd -> logEnd - adStart
            else -> adEnd - adStart
        }


    fun convertTime(time: String): Int {
        val list = time.split(":").map { it.toInt() }
        return list[2] + (list[1] + list[0] * 60) * 60
    }

    fun convertString(time: Int): String =
        String.format("%02d:%02d:%02d", time / 3600, (time % 3600) / 60, (time % 3600) % 60)


    data class Time(val start: Int, val end: Int)
}