import java.io.BufferedReader
import java.io.InputStreamReader

val directions = arrayOf (intArrayOf(-1,0), intArrayOf(0,1), intArrayOf(1,0), intArrayOf(0,-1))
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var time = readLine().toInt()
    while (time-- > 0) {
        var cntOfCandy = 0
        readLine()
        val (r,c) = readLine().split(" ").map { it.toInt() }
        val map = Array(r) {CharArray(c)}
        val circleIdxList = ArrayList<IntArray>()
        repeat(r) { rIdx ->
            map[rIdx] = readLine().toCharArray()
            map[rIdx].forEachIndexed { cIdx, c ->
                if (c == 'o') {
                    circleIdxList.add(intArrayOf(rIdx, cIdx))
                }
            }
        }

        if (r <= 2 && c <= 2) {
            println(0)
            continue
        }

        circleIdxList.forEach { circlePosition ->
            if (isCandy(map, circlePosition)) {
                cntOfCandy++
            }
        }

        println(cntOfCandy)
    }
}

fun isCandy(map: Array<CharArray>, circlePosition: IntArray): Boolean {
    if ((circlePosition[0] + directions[0][0] in map.indices && circlePosition[1] + directions[0][1] in map[0].indices) &&
        (circlePosition[0] + directions[2][0] in map.indices && circlePosition[1] + directions[2][1] in map[0].indices)) {
        if (map[circlePosition[0] + directions[0][0]][circlePosition[1] + directions[0][1]] == 'v' && map[circlePosition[0] + directions[2][0]][circlePosition[1] + directions[2][1]] == '^') {
            return true
        }
    }

    if ((circlePosition[0] + directions[3][0] in map.indices && circlePosition[1] + directions[3][1] in map[0].indices) &&
        (circlePosition[0] + directions[1][0] in map.indices && circlePosition[1] + directions[1][1] in map[0].indices)) {
        if (map[circlePosition[0] + directions[3][0]][circlePosition[1] + directions[3][1]] == '>' && map[circlePosition[0] + directions[1][0]][circlePosition[1] + directions[1][1]] == '<') {
            return true
        }
    }

    return false
}
