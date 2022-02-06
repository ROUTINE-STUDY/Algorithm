import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    if (N <= 2) {
        println(N)
        return
    }

    var firstCount = 1
    var secondCount = 2
    var lastCount = 0

    for (idx in 1 until N-1) {
        lastCount = firstCount + secondCount
        firstCount = secondCount%15746
        secondCount = lastCount%15746
    }

    println(lastCount%15746)
}