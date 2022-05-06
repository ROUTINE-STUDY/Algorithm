import java.io.BufferedReader
import java.io.InputStreamReader

val directions = arrayOf(intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1))
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val map = Array(N) { readLine().toCharArray() }

    var cntOfNormalMan = 0
    var isVisited = Array(N) { BooleanArray(N) }
    for (r in map.indices) {
        for (c in map.indices) {
            // 체크했던 좌표면 다음 좌표로
            if (isVisited[r][c]) {
                continue
            }
            normalManCheck(prevColor = map[r][c], isVisited = isVisited, map = map, r = r, c = c)
            cntOfNormalMan++
        }
    }

    isVisited = Array(N) { BooleanArray(N) }
    var cntOfRegGreenMan = 0
    for (r in map.indices) {
        for (c in map.indices) {
            // 체크했던 좌표면 다음 좌표로
            if (isVisited[r][c]) {
                continue
            }
            regGreenManCheck(prevColor = map[r][c], isVisited = isVisited, map = map, r = r, c = c)
            cntOfRegGreenMan++
        }
    }

    println("$cntOfNormalMan $cntOfRegGreenMan")
}

fun normalManCheck(prevColor: Char, isVisited: Array<BooleanArray>, map: Array<CharArray>, r: Int, c: Int) {
    // 이전 색과 현재 색이 같지 않으면 종료
    if (prevColor != map[r][c]) {
        return
    }
    isVisited[r][c] = true

    for (dir in directions) {
        val nextPosition = intArrayOf(r + dir[0], c + dir[1])
        // 다음 좌표가 맵 안에 있음
        if (nextPosition[0] in map.indices && nextPosition[1] in map[0].indices) {
            // 다음 좌표가 방문했던 좌표가 아님
            if (!isVisited[nextPosition[0]][nextPosition[1]]) {
                normalManCheck(prevColor = map[r][c], isVisited, map, r = nextPosition[0], c = nextPosition[1])
            }
        }
    }
}

fun regGreenManCheck(prevColor: Char, isVisited: Array<BooleanArray>, map: Array<CharArray>, r: Int, c: Int) {
    // 이전 색과 현재 색이 같지 않으면 종료
    if (prevColor == 'R' || prevColor == 'G') {
        if (map[r][c] == 'B') {
            return
        }
    } else {
        if (map[r][c] != 'B') {
            return
        }
    }
    isVisited[r][c] = true

    for (dir in directions) {
        val nextPosition = intArrayOf(r + dir[0], c + dir[1])
        // 다음 좌표가 맵 안에 있음
        if (nextPosition[0] in map.indices && nextPosition[1] in map[0].indices) {
            // 다음 좌표가 방문했던 좌표가 아님
            if (!isVisited[nextPosition[0]][nextPosition[1]]) {
                regGreenManCheck(prevColor = map[r][c], isVisited, map, r = nextPosition[0], c = nextPosition[1])
            }
        }
    }
}