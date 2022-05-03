import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Double.max
import kotlin.math.abs

var area = Double.MIN_VALUE
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    // 모든 점을 가지고 있는 배열
    val arrOfPoint = Array(N) { readLine().split(" ").map { it.toDouble() }.toDoubleArray()}
    // 점 방문 여부
    val isChecked = BooleanArray(N)
    // 현재 가지고 있는 점
    val currentPoints = Array(3) { DoubleArray(2) }
    getThreePoint(arrOfPoint = arrOfPoint, cnt = 0, isChecked = isChecked, currentPoints = currentPoints, 0)
    println(area)
}

fun getThreePoint(arrOfPoint: Array<DoubleArray>, cnt: Int, isChecked: BooleanArray, currentPoints: Array<DoubleArray>, currentIdx: Int) {
    if (cnt == 3) {
        // 점을 3개 구했으면, 3개로 이루어진 넓이를 구한다.
        area = max(area, getArea(currentPoints))
        return
    }

    for (idx in currentIdx until arrOfPoint.size) {
        if (isChecked[idx]) {
            continue
        }
        isChecked[idx] = true
        currentPoints[cnt] = arrOfPoint[idx]
        getThreePoint(arrOfPoint, cnt + 1, isChecked, currentPoints, idx + 1)
        isChecked[idx] = false
    }
}

fun getArea(currentPoints: Array<DoubleArray>): Double {
    val a = currentPoints[0]
    val b = currentPoints[1]
    val c = currentPoints[2]
    val s = abs((a[0] * b[1] + b[0] * c[1] + c[0] * a[1]) - (b[0] * a[1] + c[0] * b[1] + a[0] * c[1])) /2

    return s
}