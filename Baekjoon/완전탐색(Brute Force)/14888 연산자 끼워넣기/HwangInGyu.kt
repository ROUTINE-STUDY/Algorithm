import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var arrOfNumbers: IntArray
lateinit var arrOfOperators: IntArray
var max: Int = Int.MIN_VALUE
var min: Int = Int.MAX_VALUE
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cntOfNumbers = readLine().toInt()
    arrOfNumbers = readLine().split(" ").map { it.toInt() }.toIntArray()
    arrOfOperators = readLine().split(" ").map { it.toInt() }.toIntArray()

    recursion(0, arrOfNumbers[0])
    println(max)
    println(min)
}

fun recursion(idxOfNumber: Int, sum: Int) {
    if (idxOfNumber == arrOfNumbers.size-1) {
        max = max.coerceAtLeast(sum)
        min = min.coerceAtMost(sum)
        return
    }

    for (idxOfOperator in arrOfOperators.indices) {
        if (arrOfOperators[idxOfOperator] == 0) {
            continue
        }

        arrOfOperators[idxOfOperator] -= 1
        when (idxOfOperator) {
            0 -> recursion(idxOfNumber+1, sum+arrOfNumbers[idxOfNumber+1])
            1 -> recursion(idxOfNumber+1, sum-arrOfNumbers[idxOfNumber+1])
            2 -> recursion(idxOfNumber+1, sum*arrOfNumbers[idxOfNumber+1])
            3 -> recursion(idxOfNumber+1, sum/arrOfNumbers[idxOfNumber+1])
        }
        arrOfOperators[idxOfOperator] += 1
    }
}
