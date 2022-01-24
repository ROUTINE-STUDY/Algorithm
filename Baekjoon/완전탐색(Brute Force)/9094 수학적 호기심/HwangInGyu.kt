import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine()!!.toInt()) {
        val (n,m) = readLine()!!.split(" ").map { it.toInt() }
        var answer = 0
        for (a in 1 until n-1) {
            for (b in a+1 until n) {
                if ((a * a + b * b + m)%(a * b) == 0) {
                    answer++
                }
            }
        }

        println(answer)
    }
}