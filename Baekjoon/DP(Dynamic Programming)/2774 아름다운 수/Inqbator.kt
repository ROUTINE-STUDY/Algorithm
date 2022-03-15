import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val answer = StringBuilder()
    repeat(readLine().toInt()) {
        val arr = BooleanArray(10)
        var n = readLine().toInt()
        var cnt = 0
        while (n > 0) {
            if (!arr[n%10]) {
                arr[n%10] = true
                cnt++
            }
            n /= 10
        }
        answer.append(cnt).append("\n")
    }
    println(answer)
}