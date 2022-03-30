import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    println(if (N%2 == 0) "SK" else "CY")
}