import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map {it.toInt()}
    val isVisited = BooleanArray(1001)

    var sum = 0
    readLine().split(" ").map { it.toInt() }.forEach {
        var currentNum = it
        while (currentNum <= N) {
            if (!isVisited[currentNum]) {
                isVisited[currentNum] = true
                sum += currentNum
            }
            currentNum += it
        }
    }

    println(sum)
}