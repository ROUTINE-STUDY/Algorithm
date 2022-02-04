import java.io.BufferedReader
import java.io.InputStreamReader
// 1. 완전탐색
// 2. DP
var sumOfCost = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val remainingDay = readLine().toInt()
    val arrOfTheDaysTake = IntArray(remainingDay)
    val arrOfCosts = IntArray(remainingDay)
    for (day in 0 until remainingDay) {
        val (period, cost) = readLine().split(" ").map { it.toInt() }
        arrOfTheDaysTake[day] = period
        arrOfCosts[day] = cost
    }

    getMaximumCost(arrOfTheDaysTake, arrOfCosts, 0, 0)
    println(sumOfCost)
}

fun getMaximumCost(arrOfTheDaysTake: IntArray, arrOfCosts: IntArray, currentDay: Int, currentCost: Int) {
    if (currentDay >= arrOfTheDaysTake.size) {
        sumOfCost = sumOfCost.coerceAtLeast(currentCost)
        return
    }

    val nextDay = currentDay + arrOfTheDaysTake[currentDay]
    if (nextDay <= arrOfTheDaysTake.size) {
        getMaximumCost(arrOfTheDaysTake, arrOfCosts, nextDay, currentCost+arrOfCosts[currentDay])
    }
    getMaximumCost(arrOfTheDaysTake, arrOfCosts, currentDay+1, currentCost)
}
