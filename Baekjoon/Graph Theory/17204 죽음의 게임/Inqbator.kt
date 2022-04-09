import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N,K) = readLine().split(" ").map{it.toInt()}
    // 인덱스는 해당하는 사람, 값은 해당하는 사람이 가리키는 사람
    val graph = IntArray(N)
    repeat(N) { noOfPeople ->
        graph[noOfPeople] = readLine().toInt()
    }

    val isVisited = BooleanArray(N)
    var M = 0
    var noOfCurrent = 0
    while (!isVisited[noOfCurrent]) {
        isVisited[noOfCurrent] = true
        M++
        if (graph[noOfCurrent] == K) {
            break
        }
        noOfCurrent = graph[noOfCurrent]
    }

    when (graph[noOfCurrent]) {
        K -> println(M)
        else -> println(-1)
    }
}