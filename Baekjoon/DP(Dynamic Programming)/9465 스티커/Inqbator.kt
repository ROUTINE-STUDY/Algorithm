import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    // 테스트 케이스 경우의 수
    val t = readLine().toInt()
    repeat(t) {
        // 스티커 한 층의 개수
        val n = readLine().toInt()
        // 각 2행 n열 박스에 스티커의 점수를 담는 배열
        val array = Array(2) { IntArray(n) }
        val dp = Array(3) { IntArray(n) }
        repeat(2) { row ->
            val st = StringTokenizer(readLine())
            for (col in 0 until n) {
                array[row][col] = st.nextToken().toInt()
            }
        }

        // 초기화 :
        // 위에 색칠한 경우
        dp[0][0] = array[0][0]
        // 아래 색칠한 경우
        dp[1][0] = array[1][0]
        for (i in 1 until n) {
            // 이번에 위를 색칠하는 경우 = max(이전에 아래 색칠한 경우 + 위에 색칠, 이전에 색칠 안함 + 위에 색칠)
            dp[0][i] = dp[1][i - 1].coerceAtLeast(dp[2][i - 1]).plus(array[0][i])
            // 이번에 아래를 색칠하는 경우 = max(이전에 위를 색칠한 경우 + 아래를 색칠, 이전에 색칠 안함 + 아래를 색칠)
            dp[1][i] = dp[0][i - 1].coerceAtLeast(dp[2][i - 1]).plus(array[1][i])
            // 이번에 색칠을 안하는 경우 = max(이전에 위를 색칠, 이전에 아래를 색칠)
            dp[2][i] = dp[0][i - 1].coerceAtLeast(dp[1][i - 1])
        }
        bw.write("${dp[0][n - 1].coerceAtLeast(dp[1][n - 1]).coerceAtLeast(dp[2][n - 1])}\n")
    }
    bw.flush()
}