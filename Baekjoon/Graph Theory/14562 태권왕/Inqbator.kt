import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cntOfTestcase = readLine().toInt()
    repeat(cntOfTestcase) {
        val (S,T) = readLine().split(" ").map { it.toInt() }
        println(getMinKickCnt(currentKickCnt = 0, scoreOfTaeGyun = S, scoreOfEnemy = T))
    }
}

fun getMinKickCnt(currentKickCnt: Int, scoreOfTaeGyun: Int, scoreOfEnemy: Int): Int {
    // 태균이의 점수가 더 커지면 불가능하므로 정수의 최대값을 리턴
    if (scoreOfTaeGyun > scoreOfEnemy) {
        return Int.MAX_VALUE
    } else if (scoreOfTaeGyun == scoreOfEnemy) {
        // 두 사람의 점수가 같아지면 찬 회수를 리턴
        return currentKickCnt
    }

    // 둘 중 작은 값을 리턴
    return getMinKickCnt(currentKickCnt+1, scoreOfTaeGyun*2, scoreOfEnemy+3).coerceAtMost(getMinKickCnt(currentKickCnt+1, scoreOfTaeGyun+1, scoreOfEnemy))
}
