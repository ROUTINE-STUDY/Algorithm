import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var cntOfOvertakeCar = 0
    // 입력
    val N = readLine().toInt()
    // 들어온 순서
    val orderOfEntered = Array<String>(N) {"        "}
    // 나가는 순서
    val orderOfLeft = Array<String>(N){"        "}
    repeat(N) { orderOfEntered[it] = readLine() }
    repeat(N) { orderOfLeft[it] = readLine() }

    // key는 차 번호, value는 앞에 있던 차들을 담을 Set
    val map = HashMap<String, ArrayList<String>>()
    for (i in orderOfEntered.indices) {
        for (j in 0 until i) {
            if (i == j) continue
            if (map[orderOfEntered[i]] == null) {
                map[orderOfEntered[i]] = ArrayList()
            }
            map[orderOfEntered[i]]?.add(orderOfEntered[j])
        }
    }

    for (i in orderOfLeft.indices) {
        var isOvertake = false
        for (j in i+1 until orderOfLeft.size) {
            // 아예 앞에 차가 없었으면. -> map[orderOfLeft[i]]가 null이면 추월할 일이 없으므로 무조건 추월 안함.
            // -> isOverTake는 false가 추월한 차 개수는 더하지 않음.

            // 뒤에 있는 차가, 앞에 있던 차였으므로 추월한 차가 맞음.
            if (map[orderOfLeft[i]]?.contains(orderOfLeft[j]) == true) {
                isOvertake = true
                break
            }
        }

        // 추월한 차이므로 +1
        if (isOvertake) {
            cntOfOvertakeCar++
        }
    }

    println(cntOfOvertakeCar)
}