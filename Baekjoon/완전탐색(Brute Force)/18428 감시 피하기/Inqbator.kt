import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var map: Array<CharArray>
var N = 0
lateinit var teacherPosition: ArrayList<IntArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    N = readLine().toInt()
    map = Array(N){CharArray(N)}
    teacherPosition = ArrayList<IntArray>()
    repeat(N) {
        readLine().split(" ").forEachIndexed { index, s ->
            map[it][index] = s[0]
            if (s[0] == 'T') {
                teacherPosition.add(intArrayOf(it,index))
            }
        }
    }

    if (placeObstacle(map, 0)) {
        println("YES")
    } else {
        println("NO")
    }
}

fun placeObstacle(map: Array<CharArray>, cntOfPlacedObstacle: Int): Boolean {
    if (cntOfPlacedObstacle == 3) {
        if (checkDirection(teacherPosition)) {
            return true
        }
        return false
    }

    for (row in 0 until N) {
        for (column in 0 until N) {
            if (map[row][column] == 'X') {
                map[row][column] = 'O'
                if (placeObstacle(map, cntOfPlacedObstacle+1)) return true
                map[row][column] = 'X'
            }
        }
    }
    return false
}

fun checkDirection(teacherPosition: ArrayList<IntArray>): Boolean {
    teacherPosition.forEach { position ->
        var currentPosition = arrayOf(position[0],position[1])
        while (0 <= --currentPosition[0]) {
            if (map[currentPosition[0]][currentPosition[1]] == 'S') {
                return false
            } else if (map[currentPosition[0]][currentPosition[1]] == 'O') {
                break;
            }
        }
        currentPosition = arrayOf(position[0],position[1])
        while (++currentPosition[0] < N) {
            if (map[currentPosition[0]][currentPosition[1]] == 'S') {
                return false
            } else if (map[currentPosition[0]][currentPosition[1]] == 'O') {
                break;
            }
        }
        currentPosition = arrayOf(position[0],position[1])
        while (0 <= --currentPosition[1]) {
            if (map[currentPosition[0]][currentPosition[1]] == 'S') {
                return false
            } else if (map[currentPosition[0]][currentPosition[1]] == 'O') {
                break;
            }
        }
        currentPosition = arrayOf(position[0],position[1])
        while (++currentPosition[1] < N) {
            if (map[currentPosition[0]][currentPosition[1]] == 'S') {
                return false
            } else if (map[currentPosition[0]][currentPosition[1]] == 'O') {
                break;
            }
        }
    }

    return true
}
