import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val directions = arrayOf(intArrayOf(-1,0), intArrayOf(0,1), intArrayOf(1,0), intArrayOf(0,-1))
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val T = readLine().toInt()
    for (noOfTestcases in 0 until T) {
        var neededInsectCnt = 0
        val input = readLine().split(" ").map{it -> it.toInt()}
        val lenOfColumn = input[0]
        val lenOfRow = input[1]
        val cntOfCabbage = input[2]
        val map = Array(lenOfRow) { BooleanArray(lenOfColumn) }
        val arrOfCabbagePosition = Array(cntOfCabbage) {IntArray(2)}

        for (cabbage in 0 until cntOfCabbage) {
            val position = readLine().split(" ").map{it -> it.toInt()}
            arrOfCabbagePosition[cabbage][0] = position[1]
            arrOfCabbagePosition[cabbage][1] = position[0]
            map[position[1]][position[0]] = true
        }

        arrOfCabbagePosition.forEach { positionOfCabbage ->
            if (map[positionOfCabbage[0]][positionOfCabbage[1]]) {
                map[positionOfCabbage[0]][positionOfCabbage[1]] = false
                neededInsectCnt++

                val position = intArrayOf(positionOfCabbage[0], positionOfCabbage[1])
                bfs(position, map)
            }
        }

        println(neededInsectCnt)
    }
}

fun bfs(position: IntArray, map: Array<BooleanArray>) {
    val queue = LinkedList<IntArray>()
    queue.offer(position)
    while (!queue.isEmpty()) {
        val currentPosition = queue.poll()
        for (direction in directions) {
            val nextPosition = intArrayOf(currentPosition[0]+direction[0], currentPosition[1]+direction[1])
            // 다음 이동 좌표가 범위 밖이 아니면
            if (nextPosition[0] in 0..map.lastIndex && nextPosition[1] in 0..map[0].lastIndex) {
                if (map[nextPosition[0]][nextPosition[1]]) {
                    queue.offer(nextPosition)
                    map[nextPosition[0]][nextPosition[1]] = false
                }
            }
        }
    }
}
