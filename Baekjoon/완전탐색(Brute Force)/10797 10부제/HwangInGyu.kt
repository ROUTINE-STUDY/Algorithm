import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var cntOfRuleBreaker = 0
    val numberOfRestCar = readLine().toInt()
    readLine().split(" ").map {
        if (it.toInt() == numberOfRestCar) {
            cntOfRuleBreaker++
        }
    }
    println(cntOfRuleBreaker)
}
