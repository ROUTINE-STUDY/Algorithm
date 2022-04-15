import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList


val cntOfDayFriend = ArrayList<Int>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    fun getFriendPossible(relationship: Array<BooleanArray>, numOfRequiredFriends: Int): Int {
        var numOfRemainFriends = numOfRequiredFriends
        val N = relationship.size
        var day = 0
        val queue = LinkedList<Pair<Int, Int>>()
        while (numOfRemainFriends > 0) {
            day++
            // 오늘 추가된 친구수
            var addedFriend = 0
            // pivot 시작하는 사람
            repeat(N) { pivot ->
                // friend 시작하는 사람의 친구
                repeat(N) { friend ->
                    // pivot 사람의 친구면
                    if (relationship[pivot][friend]) {
                        // friendOfFriend 친구의 친구
                        repeat(N) { friendOfFriend ->
                            // 친구의 친구면, 친구의 친구가 되므로 관계를 지어줘야하므로 큐에 넣어줌.
                            if (relationship[friend][friendOfFriend] && (friendOfFriend != pivot)) {
                                queue.offer(pivot to friendOfFriend)
                            }
                        }
                    }
                }
            }

            // 큐에 있는 관계들은 모두 이어줘야 한다.
            while (queue.isNotEmpty()) {
                // Pair : 기준 사람, 친구의 친구
                val pivotAndNewFriend = queue.poll()
                val pivot = pivotAndNewFriend.first
                val newFriend = pivotAndNewFriend.second
                // 이미 친구 관계를 이어준 사람이면 다음 사람으로 넘어감
                if (relationship[pivot][newFriend] || relationship[newFriend][pivot]) {
                    continue
                }
                // 관계를 만들어줌
                relationship[pivot][newFriend] = true
                relationship[newFriend][pivot] = true
                // 관계가 1명 늘어남.
                addedFriend++
                // 남은 관계의 수가 1개 줄어듬
                numOfRemainFriends--
            }
            // 더 이상 관계를 추가하지 않아도 되면 날짜를 리턴
            cntOfDayFriend.add(addedFriend)
        }

        return day
    }

    val (N,M) = readLine().split(" ").map {it.toInt()}
    // 인접행렬
    val relationship = Array(N) { BooleanArray(N) }
    repeat(M) {
        val input = readLine().split(" ").map { it.toInt() }
        relationship[input[0]-1][input[1]-1] = true
        relationship[input[1]-1][input[0]-1] = true
    }

    // 남은 친구 관계
    val numOfRequiredFriends = ((N)*(N-1))/2 - M
    println(getFriendPossible(relationship, numOfRequiredFriends))
    cntOfDayFriend.forEach { println(it) }
}

