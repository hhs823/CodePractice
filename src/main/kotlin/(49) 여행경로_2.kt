class Solution49_2 {
    private val answer = mutableListOf<String>()

    fun solution(tickets: Array<Array<String>>): Array<String> {
        tickets.sortWith(compareBy({ it[0] }, { it[1] }))
        route(tickets.toMutableList(), null)
        return answer.toTypedArray()
    }

    private fun route(tickets: MutableList<Array<String>>, fromTicket: Array<String>?): Boolean {
        tickets
            .filter { fromTicket != null || it[0] == "ICN" }
            .filter { fromTicket == null || fromTicket[1] == it[0] }
            .forEach {
                val newFromTicket = tickets.toMutableList()
                val index = tickets.indexOf(it)
                newFromTicket.removeAt(index)

                if (newFromTicket.size == 0) {
                    answer.add(it[0])
                    answer.add(it[1])
                    return true
                } else if (route(newFromTicket, it)) {
                    answer.add(0, it[0])
                    return true
                }
            }
        return false
    }
}