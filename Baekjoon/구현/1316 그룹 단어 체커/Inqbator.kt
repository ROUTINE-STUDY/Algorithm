import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var answer = 0
    val cnt = readLine().toInt()

    for (i in 1..cnt) {
        val str = readLine()

        if (checkIsGroupStr(str)) {
            answer++
        }
    }

    println(answer)
}

fun checkIsGroupStr(str: String): Boolean {
    val visited = BooleanArray(26)
    for (i in str.indices) {
        val c = str[i]
        if (visited[c - 'a']) {
            if (str[i - 1] != c) {
                return false
            }
        }
        visited[c - 'a'] = true
    }

    return true
}
