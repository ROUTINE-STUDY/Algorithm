fun main() {
    val n = readln().toInt()
    // 각 숫자가 몇개 있는지 체크
    val nums = IntArray(10) { 1 }
    nums[0] = 0
    for (i in 1 until n) {
        // nums에 더해질 개수
        val nextNum = IntArray(10)
        for (j in 0..9) {
            if (j == 0 || j == 9) {
                if (j == 0) {
                    nextNum[1] += nums[0]
                } else {
                    nextNum[8] += nums[9]
                }
                continue
            }
            nextNum[j - 1] += nums[j]
            nextNum[j + 1] += nums[j]
        }

        for (j in 0..9) {
            nums[j] = nextNum[j] % 1000000000
        }
    }

    var answer = 0L
    for (i in 0..9) {
        answer += nums[i]
    }
    println(answer % 1000000000)
}