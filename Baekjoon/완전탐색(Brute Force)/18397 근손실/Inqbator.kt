import java.io.BufferedReader
import java.io.InputStreamReader


const val demandingWeight = 500
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var answer = 0
    val (N, K) = readLine().split(" ").map { it.toInt() }
    val isChecked = BooleanArray(N)
    val weights = readLine().split(" ").map { it.toInt() }.toIntArray()

    fun recursion(day: Int, currentWeight: Int) {
        // 현재 3대 중량이 500보다 작으면 함수 종료.
        if (currentWeight < demandingWeight) {
            return
        } else if (day == N + 1) {  // 마지막 날에 도달하면 조건을 만족하므로 경우의 수 증가.
            answer++
            return
        }

        weights.forEachIndexed { index, weight ->
            if (!isChecked[index]) {
                isChecked[index] = true
                recursion(day = day + 1, currentWeight = currentWeight + weight - K)
                isChecked[index] = false
            }
        }
    }

    recursion(day = 1, currentWeight = demandingWeight)
    println(answer)
}