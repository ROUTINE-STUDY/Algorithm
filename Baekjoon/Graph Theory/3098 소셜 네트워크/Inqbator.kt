import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList


val cntOfDayFriend = ArrayList<Int>()
var additionalDemandingFriend = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val (N,M) = readLine().split(" ").map {it.toInt()}
    val relationship = Array(N) { BooleanArray(N) }
    repeat(M) {
        val input = readLine().split(" ").map { it.toInt() }
        relationship[input[0]-1][input[1]-1] = true
        relationship[input[1]-1][input[0]-1] = true
    }

    // 현재 날짜
    var day = 0
    // 남은 친구 관계
    additionalDemandingFriend = ((N)*(N-1))/2 - M

    println(getFriendPossible(relationship))
    cntOfDayFriend.forEach { println(it) }
}

fun getFriendPossible(relationship: Array<BooleanArray>): Int {
    val N = relationship.size
    var day = 0
    val queue = LinkedList<Pair<Int, Int>>()
    while (additionalDemandingFriend > 0) {
        day++
        var addedFriend = 0
        repeat(N) { pivot ->
            repeat(N) { friend ->
                if (relationship[pivot][friend]) {
                    repeat(N) { friendOfFriend ->
                        if (relationship[friend][friendOfFriend] && (friendOfFriend != pivot)) {
                            queue.offer(pivot to friendOfFriend)
                        }
                    }
                }
            }
        }

        while (queue.isNotEmpty()) {
            val pivotAndNewFriend = queue.poll()
            val pivot = pivotAndNewFriend.first
            val newFriend = pivotAndNewFriend.second
            if (relationship[pivot][newFriend] || relationship[newFriend][pivot]) {
                continue
            }
            relationship[pivot][newFriend] = true
            relationship[newFriend][pivot] = true
            addedFriend++
            additionalDemandingFriend--

            if (additionalDemandingFriend == 0) {
                cntOfDayFriend.add(addedFriend)
                return day
            }
        }
        cntOfDayFriend.add(addedFriend)
    }

    return day
}