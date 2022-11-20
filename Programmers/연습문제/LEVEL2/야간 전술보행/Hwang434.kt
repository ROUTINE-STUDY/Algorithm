import java.util.PriorityQueue
// 야간 전술 보행
class Solution {
    fun solution(distance: Int, scope: Array<IntArray>, times: Array<IntArray>): Int {
        var currentLocation = 0
        val pq = PriorityQueue<Guard>()
        for (i in scope.indices) {
            pq.offer(Guard(range = intArrayOf(scope[i][0].coerceAtMost(scope[i][1]), scope[i][0].coerceAtLeast(scope[i][1])), time = times[i]))
        }

        while (currentLocation < distance) {
            currentLocation++
            if (pq.isEmpty()) {
                return distance
            }

            var nearestGuard = pq.peek()
            if (currentLocation > nearestGuard.range[1]) {
                pq.poll()
                continue
            } else if (currentLocation < nearestGuard.range[0]) {
                currentLocation = nearestGuard.range[0]
            }

            if (currentLocation <= nearestGuard.range[1] &&
                currentLocation % (nearestGuard.time[0] + nearestGuard.time[1]) in 1..nearestGuard.time[0]
            ) {
                return currentLocation
            }
        }

        return currentLocation
    }

    class Guard(val range: IntArray, val time: IntArray): Comparable<Guard> {
        override fun compareTo(other: Guard): Int {
            return this.range[0].compareTo(other.range[0])
        }
    }
}