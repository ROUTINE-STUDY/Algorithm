import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var averages: IntArray
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    averages = IntArray(n)
    repeat(n) {
        val input = br.readLine().split(".")
        val sb = StringBuilder()
        sb.append(input[0]).append(input[1])
        averages[it] = sb.toString().toInt()
    }

    for (cntOfPeople in 1..1000) {
        // 현재 인원수가 분모일 때, 모두 일치하는지 확인
        if (isPossibleCnt(cntOfPeople = cntOfPeople, averages = averages)) {
            println(cntOfPeople)
            break
        }
    }
}

fun isPossibleCnt(cntOfPeople: Int, averages: IntArray): Boolean {
    for (avg in averages) {
        var left = 0
        var right = 10 * cntOfPeople
        var isPossible = false
        while (left <= right) {
            // 총 점수
            val sumOfScore = (left + right) / 2
            val currentAvg = (sumOfScore * 1000) / cntOfPeople

            // if : 평균값이 타겟과 같으면
            if (currentAvg == avg) {
                if (currentAvg > 10 * 1000) {
                    continue
                }
                isPossible = true
                break
            } else if (currentAvg > avg) {
                right = (sumOfScore - 1)
            } else {
                left = (sumOfScore + 1)
            }
        }

        if (!isPossible) {
            return false
        }
    }
    return true
}