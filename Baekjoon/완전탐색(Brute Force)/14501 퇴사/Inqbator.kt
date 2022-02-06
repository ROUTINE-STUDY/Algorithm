import java.io.BufferedReader
import java.io.InputStreamReader


var N = 0
var answer = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    N = readLine().toInt()
    val arrOfTheDaysTake = IntArray(N)
    val arrOfCosts = IntArray(N)
    for (day in  0 until N) {
        val (period, cost) = readLine().split(" ").map { it.toInt() }
        arrOfTheDaysTake[day] = period
        arrOfCosts[day] = cost
    }

    val dp = IntArray(arrOfTheDaysTake.size+1)
    getMaximumCost(arrOfTheDaysTake, arrOfCosts, 0, dp)
    println(answer)
}

fun getMaximumCost(arrOfTheDaysTake: IntArray, arrOfCosts: IntArray, currentDay: Int, dp: IntArray) {
    if (currentDay >= N) {
        return
    } else if (currentDay > 0) {
        dp[currentDay] = dp[currentDay].coerceAtLeast(dp[currentDay-1])
    }

    val nextDay = currentDay + arrOfTheDaysTake[currentDay]
    if (nextDay < N+1) {
        dp[nextDay] = dp[nextDay].coerceAtLeast(dp[currentDay]+arrOfCosts[currentDay])
        answer = answer.coerceAtLeast(dp[nextDay])
    }

    getMaximumCost(arrOfTheDaysTake, arrOfCosts, currentDay+1, dp)
}
