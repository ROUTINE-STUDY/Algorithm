import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

val dy = intArrayOf(-1,0,1,0)
val dx = intArrayOf(0,1,0,-1)
lateinit var map: Array<IntArray>
data class Virus(val noOfVirus: Int, val row: Int, val col: Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 바이러스를 담을 리스트
    val listOfVirusPosition = ArrayList<Virus>()
    val (N, K) = readLine().split(" ").map{it.toInt()}
    map = Array(N){ IntArray(N) }

    repeat(N) { row ->
        var col = 0
        readLine().split(" ").map { it.toInt() }.forEach { noOfVirus ->
            if (noOfVirus != 0) {
                listOfVirusPosition.add(Virus(noOfVirus = noOfVirus, row = row, col = col))
                map[row][col] = noOfVirus
            }
            col++
        }
    }

    val queue = LinkedList<Virus>()
    listOfVirusPosition.sortedWith { o1, o2 -> o1.noOfVirus - o2.noOfVirus }.forEach { virus ->
        queue.offer(virus)
    }

    val (S, X, Y) = readLine().split(" ").map { it.toInt() }
    repeat(S) {
        val sizeOfQ = queue.size
        repeat(sizeOfQ) {
            val virus = queue.poll()
            for (idxDirection in 0..3) {
                val nextRow = virus.row + dy[idxDirection]
                val nextCol = virus.col + dx[idxDirection]

                if (nextRow in 0 until N && nextCol in 0 until N) {
                    if (map[nextRow][nextCol] == 0) {
                        map[nextRow][nextCol] = virus.noOfVirus
                        queue.offer(Virus(noOfVirus = virus.noOfVirus, row = nextRow, col = nextCol))
                    }
                }
            }
        }
    }

    println(map[X-1][Y-1])
}