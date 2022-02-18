import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var map: Array<IntArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (lenOfRow, lenOfColumn) = readLine().split(" ").map { it.toInt() }
    map = Array(lenOfRow){IntArray(lenOfColumn)}
    repeat(lenOfRow) {
        readLine().forEachIndexed { index, c ->
            map[it][index] = c.digitToInt()
        }
    }

    if (lenOfRow == 1 && lenOfColumn == 1) {
        if (map[0][0] == 1) {
            println(1)
        } else {
            println(-1)
        }
        return
    }

    println(bfs(intArrayOf(0,0), lenOfRow, lenOfColumn))
}

fun bfs(position: IntArray, lenOfRow: Int, lenOfColumn: Int): Int {
    var distance = 1
    val isVisited = Array(map.size) {BooleanArray(map[0].size)}
    isVisited[0][0] = true
    val directions = arrayOf(intArrayOf(-1,0), intArrayOf(0,1), intArrayOf(1,0), intArrayOf(0,-1))
    val q = LinkedList<IntArray>()
    q.offer(position)

    while (!q.isEmpty()) {
        val size = q.size
        for (i in 1..size) {
            val currentPosition = q.poll()
            for (direction in directions) {
                val nextPosition = intArrayOf(currentPosition[0]+direction[0], currentPosition[1]+direction[1])

                if (nextPosition[0] == lenOfRow-1 && nextPosition[1] == lenOfColumn-1) {
                    return distance+1
                }
                if (nextPosition[0] in 0 until lenOfRow && nextPosition[1] in 0 until lenOfColumn) {
                    if (map[nextPosition[0]][nextPosition[1]] == 0) {
                        continue
                    }

                    if (!isVisited[nextPosition[0]][nextPosition[1]]) {
                        q.offer(nextPosition)
                        isVisited[nextPosition[0]][nextPosition[1]] = true
                    }
                }
            }
        }
        distance++
    }

    return -1
}
