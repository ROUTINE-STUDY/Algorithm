fun main() {
    // 1 <= M <= N <= 10,000
    // M이상 N이하의 소수들의 총합과 최솟값을 구하시오.
    val m = readln().toInt()
    val n = readln().toInt()
    val prime = BooleanArray(n + 2) { true }
    checkPrime(prime)

    var sumOfDecimal = 0
    var firstNum = 0
    var isFirstPrime = true
    for (i in m..n) {
        if (prime[i]) {
            sumOfDecimal += i
            if (isFirstPrime) {
                firstNum = i
                isFirstPrime = false
            }
        }
    }
    // 아직 첫번째 소수가 나오지 않았음
    if (isFirstPrime) {
        println(-1)
    } else {
        println("$sumOfDecimal\n$firstNum")
    }
}

fun checkPrime(prime: BooleanArray) {
    prime[0] = false
    prime[1] = false
    var decimal = 2
    while (decimal * decimal < prime.size - 1) {
        // if : 소수가 아니면 넘어감
        if (!prime[decimal]) {
            decimal++
            continue
        }

        // 소수의 배수들은 전부 소수가 아니다.
        var multipliedNum = 2
        while (decimal * multipliedNum < prime.size) {
            prime[decimal * multipliedNum] = false
            multipliedNum++
        }
        decimal++
    }
}