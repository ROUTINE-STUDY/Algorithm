import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (cntOfSampleTest, cntOfPrivateTest) = readLine().split(" ").map {it.toInt()}
    fun checkIsAllCorrect(cntOfCase: Int): Boolean {
        repeat(cntOfCase) {
            val (myAnswer, realAnswer) = readLine().split(" ").map { it.toInt() }
            if (myAnswer != realAnswer) {
                return false
            }
        }
        return true
    }

    val outputMsg = if (!checkIsAllCorrect(cntOfSampleTest))
        "Wrong Answer"
    else if (!checkIsAllCorrect(cntOfPrivateTest))
        "Why Wrong!!!"
    else
        "Accepted"

    println(outputMsg)
}