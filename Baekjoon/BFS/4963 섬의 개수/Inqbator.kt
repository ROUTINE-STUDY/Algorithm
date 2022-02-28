import java.io.BufferedReader
import java.io.InputStreamReader

// 1은 땅 0은 바다
val dy = intArrayOf(-1,0,1,0,-1,1,1,-1)
val dx = intArrayOf(0,1,0,-1,1,1,-1,-1)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    while (true) {
        val (w,h) = readLine().split(" ").map {it.toInt()}
        if (w == 0 || h == 0) {
            return
        }

        val map = Array(h){IntArray(w)}
        val isVisited = Array(h){BooleanArray(w)}
        repeat(h) {
            map[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
        }

        var cntOfLand = 0
        for (idxOfRow in 0 until h) {
            for (idxOfColumn in 0 until w) {
                // 방문하지 않은 곳이고, 땅이면 dfs 시작.
                if (!isVisited[idxOfRow][idxOfColumn] && map[idxOfRow][idxOfColumn] == 1) {
                    checkLand(isVisited, map, idxOfRow, idxOfColumn)
                    cntOfLand++
                }
            }
        }

        println(cntOfLand)
    }
}

fun checkLand(visited: Array<BooleanArray>, map: Array<IntArray>, startDy: Int, startDx: Int) {
    // 현재 좌표가 맵 밖이거나, 이미 방문한 곳이거나, 바다(0)면 끝
    if (startDy !in map.indices || startDx !in map[0].indices || visited[startDy][startDx] || map[startDy][startDx] == 0) {
        return
    } else {
        // 다 만족하면 방문처리
        visited[startDy][startDx] = true
    }

    for (idxOfDire in dy.indices) {
        checkLand(visited, map, startDy+dy[idxOfDire], startDx+dx[idxOfDire])
    }
}
