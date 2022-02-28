import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

// BFS를 위한 큐. 매번 만들어줄 필요가 없으므로 탑 레벨에 선언.
val queue = LinkedList<IntArray>()
val directions = arrayOf(intArrayOf(-1,0), intArrayOf(0,1), intArrayOf(1,0), intArrayOf(0,-1))
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 최대 섬개수는 비가 안왔을 때 1이 기본.
    // [S] 입력
    var cntOfMaxIsland = 1
    val N = readLine().toInt()
    val map = Array(N){IntArray(N)}
    var highestHeight = 0
    repeat(N) { idxOfRow ->
        val st = StringTokenizer(readLine(), " ")

        var idxOfCol = 0
        while (st.hasMoreTokens()) {
            val height = st.nextToken().toInt()
            map[idxOfRow][idxOfCol++] = height
            highestHeight = highestHeight.coerceAtLeast(height)
        }
    }
    // [E] 입력

    // 강수량
    var precipitation = 1
    // 최저 강수량 1부터 (최고 높이-1)까지 확인(최고 높이까지 비가오면 어차피 섬의 개수는 0이니까 확인 안함)
    while (precipitation < highestHeight) {
        cntOfMaxIsland = bfs(map, precipitation).coerceAtLeast(cntOfMaxIsland)
        // 현재 강수량은 체크했으므로, 강수량을 1높여서 체크
        precipitation++
    }

    println(cntOfMaxIsland)
}

fun bfs(map: Array<IntArray>, precipitation: Int): Int {
    val isVisited = Array(map.size){BooleanArray(map[0].size)}
    var cntOfIsland = 0

    for (row in map.indices) {
        for (column in map[row].indices) {
            // 높이가 강수량보다 높고, 방문하지 않았던 노드면 시작
            if (map[row][column] > precipitation && !isVisited[row][column]) {
                isVisited[row][column] = true
                queue.offer(intArrayOf(row, column))

                // BFS
                while (!queue.isEmpty()) {
                    val currentPosition = queue.poll()
                    for (idxOfDire in directions.indices) {
                        val nextPosition = intArrayOf(currentPosition[0]+directions[idxOfDire][0], currentPosition[1]+directions[idxOfDire][1])
                        // 다음 위치가 맵 안에 있고, 방문하지 않았고
                        if (nextPosition[0] in map.indices && nextPosition[1] in map.indices && !isVisited[nextPosition[0]][nextPosition[1]]) {
                            // 높이가 강수량보다 높으면 queue에 넣어서 BFS
                            if (map[nextPosition[0]][nextPosition[1]] > precipitation) {
                                queue.offer(nextPosition)
                            }
                            // 방문하지 않았는데 어차피 잠긴 땅이면 방문 처리.(다음에 방문하지 않게)
                            isVisited[nextPosition[0]][nextPosition[1]] = true
                        }
                    }
                }

                // row, column 시작점으로 잡은 대륙은 전부 체크했으므로 +1
                cntOfIsland++
            }
        }
    }

    return cntOfIsland
}