import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

val directions = arrayOf<IntArray>(intArrayOf(-1,0), intArrayOf(0,1), intArrayOf(1,0), intArrayOf(0,-1))
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var day = 0
    val (cLength, rLength) = readLine().split(" ").map { it.toInt() }
    // 방문 여부 기록
    val box = Array(rLength) { IntArray(cLength) }
    // 안 익은 토마토의 개수
    var cntOfUnRottenTomatoes = 0

    // 익은 토마토의 좌표를 담을 큐
    val queue = LinkedList<IntArray>()
    // 토마토 상태 입력 받기
    repeat(rLength) { rIdx ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { cIdx, status ->
            box[rIdx][cIdx] = status
            // 익은 토마토의 좌표는 큐에 넣는다.
            if (status == 1) {
                queue.offer(intArrayOf(rIdx, cIdx))
            }

            // 익지 않은 개수 추가
            if (status == 0) {
                cntOfUnRottenTomatoes++
            }
        }
    }

    // 익지 않은 토마토가 없으면 0일마에 모든 토마토가 익는다.
    if (cntOfUnRottenTomatoes == 0) {
        println(0)
        return
    }

    while (!queue.isEmpty()) {
        day++
        val qSize = queue.size

        // 오늘 하루 동안 체크할 토마토 주변
        for (i in 1..qSize) {
            // 익은 토마토의 좌표
            val rPosition = queue.poll()

            // 익은 토마토의 4방향을 조사.
            for (direction in directions) {
                val nextPosition = intArrayOf(rPosition[0]+direction[0], rPosition[1]+direction[1])
                // 다음 좌표가 맵 안에 있고.
                if (nextPosition[0] in 0 until rLength && nextPosition[1] in 0 until cLength) {
                    // 익지 않은 토마토가 있으면.
                    if (box[nextPosition[0]][nextPosition[1]] == 0) {
                        // 해당 토마토는 익은 토마토가 된다.
                        box[nextPosition[0]][nextPosition[1]] = 1
                        // 해당 토마토에서 다시 전염 시작
                        queue.offer(nextPosition)

                        cntOfUnRottenTomatoes--
                    }
                }
            }
        }

        // 만약 익은 토마토의 개수가 0이 되면, 모두 익었으므로 날짜를 출력
        if (cntOfUnRottenTomatoes == 0) {
            println(day)
            return
        }
    }

    // 익은 개수가
    println(-1)
}