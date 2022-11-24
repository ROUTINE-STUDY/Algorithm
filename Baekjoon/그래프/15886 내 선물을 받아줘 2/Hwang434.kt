fun main() {
    readln()
    val map = readln().toCharArray()
    val parents = IntArray(map.size) { it }
    val visited = BooleanArray(map.size)

    for (i in map.indices) {
        var currentParent = i
        var currentPoint = i
        if (visited[i]) {
            continue
        }
        visited[i] = true

        while (true) {
            val nextPoint = when (map[currentPoint]) {
                'W' -> {
                    currentPoint - 1
                }
                else -> {
                    currentPoint + 1
                }
            }

            currentParent = currentParent.coerceAtMost(parents[nextPoint])
            parents[currentPoint] = currentParent
            parents[nextPoint] = currentParent

            if (visited[nextPoint]) {
                break
            }
            visited[nextPoint] = true

            currentPoint = nextPoint
        }
    }

    println(parents.distinct().size)
}