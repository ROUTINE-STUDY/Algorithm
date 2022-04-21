import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    // 정사각형의 최소 길이
    val minLength = 1
    // 정답
    var answer = minLength * minLength
    // 정사각형의 최대 길이
    val maxLength = N.coerceAtLeast(M)
    // 정사각형 지도
    val square = Array(N) { IntArray(M) }
    repeat(N) { rIdx ->
        readLine().forEachIndexed { cIdx, value ->
            square[rIdx][cIdx] = value.digitToInt()
        }
    }

    for (length in maxLength downTo 1) {
        for (rIdx in square.indices) {
            for (cIdx in square[rIdx].indices) {
                // 정사각형의 좌표를 벗어나면 continue
                if (rIdx + length - 1 >= N || cIdx + length - 1 >= M) {
                    continue
                }

                // 정사각형의 네 점의 좌표의 값이 같으면 크기를 갱신해줌.
                val pivot = square[rIdx][cIdx]
                if (pivot == square[rIdx][cIdx + length - 1] &&
                    pivot == square[rIdx + length - 1][cIdx + length - 1] &&
                    pivot == square[rIdx + length - 1][cIdx]
                ) {
                    answer = length * length
                    println(answer)
                    return
                }
            }
        }
    }

    println(-1)
}
