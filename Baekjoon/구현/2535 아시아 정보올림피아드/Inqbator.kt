import java.io.BufferedReader
import java.io.InputStreamReader

data class Participant(val cNo: Int, val sNo: Int, val score: Int) : Comparable<Participant> {
    override fun compareTo(other: Participant): Int {
        return other.score - this.score
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val output = StringBuilder()
    val N = readLine().toInt()
    val arrOfCountryMedalCnt = IntArray(101)
    val arrOfParticipant = Array(N) {
        val input = readLine().split(" ").map { it.toInt() }
        Participant(input[0], input[1], input[2])
    }
    arrOfParticipant.sort()

    var idxOfStudent = 0
    var cntOfRemainMedal = 3
    // 남은 메달 개수가 0보다 크고, 인덱스가 마지막 참가자 번호보다 작으면
    while (cntOfRemainMedal > 0 && idxOfStudent < N) {
        val participant = arrOfParticipant[idxOfStudent]
        // 해당 국가가 메달을 2개도 못받았으면
        if (arrOfCountryMedalCnt[participant.cNo] < 2) {
            output.append(participant.cNo).append(" ").append(participant.sNo).append("\n")
            arrOfCountryMedalCnt[participant.cNo]++
            cntOfRemainMedal--
        }

        idxOfStudent++
    }

    println(output.deleteCharAt(output.length - 1))
}