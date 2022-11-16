fun main() {
    val t = readln().toInt()
    val answer = StringBuilder()

    for (noOfTestcase in 1..t) {
        val n = readln().toInt()
        val map = Array(n) { readln().toInt() - 1 }
        val visited = Array(n) { false }

        var currentMovement = 0
        var currentPoint = 0
        visited[currentPoint] = true
        while (currentPoint != n - 1) {
            val nextPoint = map[currentPoint]
            if (visited[nextPoint]) {
                answer.append("0\n")
                break
            }
            visited[nextPoint] = true
            currentMovement++
            currentPoint = nextPoint
        }

        if (currentPoint == n - 1) {
            answer.append("$currentMovement\n")
        }
    }

    println(answer)
}