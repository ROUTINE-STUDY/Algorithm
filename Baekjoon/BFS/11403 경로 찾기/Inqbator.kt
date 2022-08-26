import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))
fun main() {
    val n = br.readLine().toInt()
    val map = Array(n) { LinkedList<Int>() }

    repeat(n) {
        val line = br.readLine().split(" ").map { it.toInt() }
        line.forEachIndexed {idx, x ->
            if (x == 1) {
                map[it].add(idx)
            }
        }
    }

    for (start in 0 until n) {
        bfs(start, map)
    }
    bw.flush()
}

fun bfs(startPoint: Int, map: Array<LinkedList<Int>>) {
    val visited = BooleanArray(map.size)
    val queue = LinkedList<Int>()

    var isCycle = false
    queue.offer(startPoint)
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        visited[node] = true

        for (next in map[node]) {
            // 시작지점이면 체크하고 큐에 넣지는 않음.
            if (next == startPoint) {
                isCycle = true
                continue
            }

            if (visited[next]) {
                continue
            }

            visited[next] = true
            queue.offer(next)
        }
    }

    for (i in visited.indices) {
        if (i == startPoint) {
            if (isCycle) {
                bw.write("1")
            } else {
                bw.write("0")
            }
            bw.write(" ")
            continue
        }

        if (visited[i]) {
            bw.write("1")
        } else {
            bw.write("0")
        }
        bw.write(" ")
    }

    bw.write("\n")
}