class Solution22 {
    fun solution(s: String, n: Int): String {

        return s.map { if(it.isLetter()) push(it, n) else it }.joinToString("")
    }

    fun push(c: Char, n: Int): Char =
        if (c.isUpperCase()) {
            val i = c.toInt() - 'A'.toInt()
            ((i + n) % 26 + 'A'.toInt()).toChar()
        } else {
            val i = c.toInt() - 'a'.toInt()
            ((i + n) % 26 + 'a'.toInt()).toChar()
        }
}