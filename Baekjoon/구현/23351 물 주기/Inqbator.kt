import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N,K,A,B) = readLine().split(" ").map {it.toInt()}
    // 현재 날짜
    var day = 0
    // 마지막 화분에 남은 물
    var restWater = K
    // 화분에 물을 주는 주기
    val cycle = N/A
    // 화분에 물이 다 마르면 종료
    while (0 < restWater) {
        day++
        // 주기마다 물을 주고, 1이 증발한다.
        if ((day)%cycle == 0) {
            restWater += (B-1)
        } else {
            restWater--
        }
    }

    println(day)
}