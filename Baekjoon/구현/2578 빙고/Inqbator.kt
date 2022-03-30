import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // key를 값 value를 좌표인 map을 만듬.
    val map = Array(26){IntArray(2)}
    // 세로 빙고를 만족하기 위해 필요한 체크 개수
    val sero = intArrayOf(5,5,5,5,5)
    // 가로 빙고를 만족하기 위해 필요한 체크 개수
    val garo = intArrayOf(5,5,5,5,5)
    // 좌상단에서 우하단으로 가는 빙고와, 우상단에서 좌하단으로 가는 빙고를 위해 필요한 체크 개수
    val daegaek = intArrayOf(5,5)
    // key를 블록의 값으로, value는 해당 블록의 좌표를 가르킨다.
    repeat(5) { row ->
        readLine().split(" ").map { it.toInt() }.forEachIndexed { col, num ->
            map[num][0] = row
            map[num][1] = col
        }
    }

    // 몇번째 불렸는지 체크하는 변수
    var idxOfCall = 0
    // 현재 빙고의 개수
    var cntOfBingo = 0
    repeat(5) { row ->
        //
        readLine().split(" ").map { it.toInt() }.forEach { calledNum ->
            idxOfCall++
            val position = map[calledNum]!!

            // (0,0), (1,1)처럼 같으면 대각 좌상단에서 우하단으로 가는 대각선임.
            if (position[0] == position[1]) {
                daegaek[0]--
                if (daegaek[0] == 0) {
                    cntOfBingo++
                }
            }
            // 두 좌표의 합이 4면 좌하단에서 우상단으로 가는 대각선임
            if (position[0] + position[1] == 4) {
                daegaek[1]--
                if (daegaek[1] == 0) {
                    cntOfBingo++
                }
            }

            // 세로와 가로 빙고 필요 개수를 줄여주고 빙고가 완성되면 빙고 개수를 추가함.
            --sero[position[1]]
            --garo[position[0]]
            if (sero[position[1]] == 0) {
                cntOfBingo++
            }
            if (garo[position[0]] == 0) {
                cntOfBingo++
            }

            // 빙고가 3개 이상 완료 되면 결과를 출력하고 프로그램 종료
            if (cntOfBingo >= 3) {
                println(idxOfCall)
                return
            }
        }
    }

    println(-1)
}