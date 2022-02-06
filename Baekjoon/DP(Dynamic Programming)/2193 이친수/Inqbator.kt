import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val arrOfPinaryNumber = LongArray(N)
    if (N <= 2) {
        println(1)
        return
    }

    arrOfPinaryNumber[0] = 1
    arrOfPinaryNumber[1] = 1
    for (idx in 0 until N-2) {
        arrOfPinaryNumber[idx+2] = arrOfPinaryNumber[idx] + arrOfPinaryNumber[idx+1]
    }

    println(arrOfPinaryNumber[N-1])
}