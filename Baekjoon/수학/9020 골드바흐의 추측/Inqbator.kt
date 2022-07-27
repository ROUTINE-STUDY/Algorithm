import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    // 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다.
    // n에 골드 바흐 파티션을 구하시오.
    // 단, 골드바흐 파티션이 여러 개면 두 소수의 차이가 가장 작은 것을 구하시오.
    // 10001까지에 소수를 구한다.

    // 짝수 a가 주어진다.
    // a/2~a까지 for문을 도는데 만약 i번째가 소수고 a - i가 소수면 그 수는 골드바흐
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 테스트 케이스 개수
    val t = br.readLine().toInt()
    val questions = IntArray(t)
    var primeSize = Int.MIN_VALUE
    repeat(t) { idx ->
        val evenNum = br.readLine().toInt()
        questions[idx] = evenNum
        primeSize = primeSize.coerceAtLeast(evenNum)
    }

    val prime = BooleanArray(primeSize) { true }
    checkPrimeNum(prime)
    questions.forEach { questionNum ->
        val pair = getGoldNum(prime, questionNum)
        pair?.let { bw.write("${it.first} ${it.second}\n") }
    }
    bw.flush()
}

fun getGoldNum(prime: BooleanArray, questionNum: Int): Pair<Int, Int>? {
    for (rightNum in questionNum/2..questionNum) {
        if (prime[rightNum] && prime[questionNum - rightNum]) {
            return questionNum - rightNum to rightNum
        }
    }

    return null
}

fun checkPrimeNum(prime: BooleanArray) {
    prime[0] = false
    prime[1] = false
    for (i in 2 until prime.size) {
        // if : 소수가 아니면 넘어감
        if (!prime[i]) {
            continue
        }

        // 소수면 배수는 전부다 소수가 아니다.
        var multipliedNum = 2
        while (i * multipliedNum < prime.size) {
            prime[i * multipliedNum] = false
            multipliedNum++
        }
    }
}
