import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val numbers = readLine().split(" ").map { it.toInt() }
    println(getAlmostMultipleNumber(numbers))
}

fun getAlmostMultipleNumber(numbers: List<Int>): Int {
    for (multipleNumber in 1 until 1000000) {
        var cntOfDividedNumber = 0
        for (number in numbers) {
            if (multipleNumber%number == 0) {
                cntOfDividedNumber++
                if (cntOfDividedNumber ==  3) {
                    return multipleNumber
                }
            }
        }
        cntOfDividedNumber = 0
    }

    return -1
}