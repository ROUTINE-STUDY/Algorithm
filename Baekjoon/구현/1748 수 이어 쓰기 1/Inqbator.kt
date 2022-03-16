import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow


fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var answer = 0
    var N = readLine().toInt()
    // 자리수
    var a = 0

    // 자리수 구하기
    var temp = N
    while (temp > 0) {
        temp /= 10
        a++
    }


    // 자리수 -1까지 구하기(N이 158이면 99까지의 개수)
    var c = 9
    temp = a
    var l = 1
    while (--temp > 0) {
        answer += c*l
        c *= 10
        l++
    }

    // 자리수까지 개수 구하기(N이 158이면 100~158
    answer += a*(N- 10.0.pow((a - 1)).toInt()+1)
    println(answer)
}