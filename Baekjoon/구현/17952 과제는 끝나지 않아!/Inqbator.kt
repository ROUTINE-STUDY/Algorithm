import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Subject(val score: Int, var remainTime: Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var totalScore = 0
    val stack = Stack<Subject>()
    var time = readLine().toInt()

    while (time-- > 0) {
        val input = readLine().split(" ").map { it.toInt() }
        // 과제가 주어지지 않음.
        if (input.size == 1) {
            if (!stack.isEmpty()) {
                // 이전에 하던 과제의 남은 시간을 줄이고 0이 되면 점수를 더함.
                stack.pop().let {
                    it.remainTime--
                    if (it.remainTime == 0) {
                        totalScore += it.score
                    } else {
                        stack.push(it)
                    }
                }
            }
        } else {
            // 새로운 과제가 주어짐.
            // 주어진 과제 시간이 1초 이하면 스택에 안 넣고 바로 점수 추가함.
            if (input[2] <= 1) {
                totalScore += input[1]
            } else {
                stack.push(Subject(input[1], input[2]-1))
            }
        }
    }

    println(totalScore)
}