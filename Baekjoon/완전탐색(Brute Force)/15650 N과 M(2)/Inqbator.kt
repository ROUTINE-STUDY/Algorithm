import java.util.*

fun main() {
    // 1 <= M <= N <= 8, N^N해도 시간적 여유가 있음(브루트 포스 가능)
    // 중복 없이 고른 수열
    // 오름차 순이어야 한다.
    val (n, m) = readln().split(" ").map { it.toInt() }
    println(getSequential(m, 0, sequence = LinkedList(), n))
}

// remainCnt : 남은 수열의 요소 개수
// prevNum : 이전 선택한 수열의 값 (1,3 -> 3이 이전 선택한 값)
// sequnce: 현재 수열의 상태
// n: 마지막 숫자
fun getSequential(remainCnt: Int, prevNum: Int, sequence: LinkedList<Int>, n: Int): StringBuilder {
    val sb = StringBuilder()
    // if : 남은 개수보다 남은 숫자가 적으면 끝
    if (remainCnt > n - prevNum) {
        return sb
    } else if (remainCnt == 0) {
        sequence.forEach {
            sb.append("$it ")
        }
        sb.append("\n")
        return sb
    } else if (prevNum == n) {
        return sb
    }

    for (i in prevNum + 1..n) {
        sequence.add(i)
        sb.append(getSequential(remainCnt - 1, prevNum = i, sequence, n))
        sequence.removeLast()
    }
    return sb
}