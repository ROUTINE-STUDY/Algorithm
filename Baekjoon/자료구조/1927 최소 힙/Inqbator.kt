import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readLine().toInt()
    val pq = PriorityQueue<Int>()

    for (i in 1..n) {
        val num = readLine().toInt()
        if (num != 0) {
            pq.offer(num)
            continue
        }

        var temp = 0
        if (pq.isNotEmpty()) {
            temp = pq.poll()
        }
        bw.write("$temp\n")
    }
    bw.flush()
}