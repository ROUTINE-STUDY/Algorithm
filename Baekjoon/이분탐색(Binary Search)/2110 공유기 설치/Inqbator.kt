import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, C) = readLine().split(" ").map { it.toInt() }
    val map = IntArray(N)
    map.forEachIndexed { index, i ->
        map[index] = readLine().toInt()
    }
    map.sort()

    var left = 1
    var right = map[N-1]
    var avgDistance = 0
    while (left <= right) {
        avgDistance = left + (right-left)/2
        var installedWifi = 1

        var prevCity = map[0]
        for (idx in map.indices) {
            val realDistance = map[idx]- prevCity
            if (realDistance >= avgDistance) {
                installedWifi++
                prevCity = map[idx]
            }
        }

        if (installedWifi >= C) {
            left = avgDistance+1
        } else {
            right = avgDistance-1
        }
    }

    println(left-1)
}