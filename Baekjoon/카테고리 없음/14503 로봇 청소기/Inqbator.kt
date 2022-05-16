import java.io.BufferedReader
import java.io.InputStreamReader

// direction이 x이면 (현재 좌표 + leftDirection[x]) == 왼쪽 좌표
val forwardDirection = arrayOf( intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1))
val leftDirection = arrayOf( intArrayOf(0, -1), intArrayOf(-1,0), intArrayOf(0, 1), intArrayOf(1, 0))
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // N : 맵의 행 크기, M : 맵의 열 크기
    val (N, M) = readLine().split(" ").map { it.toInt() }
    // r : 로봇 행, c : 로봇 열, d : 로봇 방향
    val (r, c, d) = readLine().split(" ").map { it.toInt() }
    // 0이면 빈 공간, 1이면 벽
    val map = Array(N) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    // 청소 여부
    val isCleaned = Array(N) { BooleanArray(M) }
    val robot = Robot(position = intArrayOf(r,c), direction = d, map = map, isCleaned = isCleaned, cntOfCleaned = 0)
    robot.execute()
    println(robot.cntOfCleaned)
}

class Robot(val position: IntArray, var direction : Int, val map : Array<IntArray>, val isCleaned : Array<BooleanArray>, var cntOfCleaned : Int = 0) {
    var aExecuted = 0
    fun execute() {
        while (true) {
            //    1. 현재 위치를 청소한다.
            if (!isCleaned[position[0]][position[1]]) {
                clean()
                cntOfCleaned++
            }

            if (aExecuted == 4) {
                // 후진 실패 -> 작동 정지
                if (!moveBackward()) {
                    return
                } else {
                    aExecuted = 0
                }
            }
            //    2. 현재 위치에서 다음을 반복하면서 인접한 칸을 탐색한다.
            //    2.a 현재 위치의 바로 왼쪽에 아직 청소하지 않은 빈 공간이 존재한다면, 왼쪽 방향으로 회전한 다음 한 칸을 전진하고 1번으로 돌아간다.
            //    그렇지 않을 경우, 왼쪽 방향으로 회전한다. 이때, 왼쪽은 현재 바라보는 방향을 기준으로 한다.
            if (!isLeftCleaned()) {
                rotateLeft()
                moveForward()
                aExecuted = 0
                continue
            } else {
                rotateLeft()
                aExecuted++
            }
            //    2.b 1번으로 돌아가거나 후진하지 않고 2a번 단계가 연속으로 네 번 실행되었을 경우, 바로 뒤쪽이 벽이라면 작동을 멈춘다. 그렇지 않다면 한 칸 후진한다.
        }
    }

    private fun clean() {
        isCleaned[position[0]][position[1]] = true
    }

    private fun isLeftCleaned() : Boolean {
        val leftPosition = intArrayOf(position[0] + leftDirection[direction][0], position[1] + leftDirection[direction][1])
        if (!isBlocked(leftPosition)) {
            if (!isCleaned[leftPosition[0]][leftPosition[1]]) {
                return false
            }
        }

        return true
    }

    private fun moveForward() {
        position[0] = position[0] + forwardDirection[direction][0]
        position[1] = position[1] + forwardDirection[direction][1]
    }

    private fun moveBackward() : Boolean {
        val backDirection = if (direction >= 2) {
            direction - 2
        } else {
            direction + 2
        }

        val backPosition = intArrayOf(position[0] + forwardDirection[backDirection][0], position[1] + forwardDirection[backDirection][1])
        // 벽을 만나면 움직임을 실패했으므로 false를 리턴
        // 벽을 만나지 않으면 이동하고 성공했으므로 true를 리턴
        return when {
            isBlocked(backPosition) -> {
                false
            }
            else -> {
                position[0] = backPosition[0]
                position[1] = backPosition[1]
                true
            }
        }
    }

    // 왼쪽으로 회전
    private fun rotateLeft() {
        if (--direction < 0 ) {
            direction = 3
        }
    }

    // 다음 좌표가 1이면 벽이므로 못감
    private fun isBlocked(nextPosition: IntArray) : Boolean {
        if (map[nextPosition[0]][nextPosition[1]] != 1) {
            return false
        }
        return true
    }
}