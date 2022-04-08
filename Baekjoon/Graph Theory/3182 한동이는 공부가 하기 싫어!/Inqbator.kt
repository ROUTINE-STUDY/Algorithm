import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 현재 최고 인맥 선배
    var noOfBestElder = 0
    // 현재 최고로 많이 만난 게 몇명인지
    var maxPathLength = Int.MIN_VALUE
    // 선배 인원수
    val cntOfElder = readLine().toInt()
    // 선배 번호는 1번부터 시작이므로 배열을 인원수보다 1 크게 만들어준다.
    val relationship = IntArray(cntOfElder+1)

    // 선배가 추천하는 선배를 입력해준다
    // 인덱스 : 현재 선배의 번호, 값 : 현재 선배가 추천하는 다음 선배 번호
    for (numOfElder in 1..cntOfElder) {
        relationship[numOfElder] = readLine().toInt()
    }

    // 1~N번까지 번호를 시작점으로 잡고 최대 몇명을 만나는지 확인한다.
    for (numOfElder in 1..cntOfElder) {
        // 현재 선배를 통해 만나고 있는 사람 수
        var currentPathLength = 1
        val map = BooleanArray(cntOfElder+1)

        // 현재 만나고 있는 선배 번호
        var currentPosition = numOfElder
        map[currentPosition] = true
        // 만났던 선배면 반복문을 종료한다.
        while (!map[relationship[currentPosition]]) {
            // 만났던 선배가 아니므로 만난 선배 인원수가 추가됨.
            currentPathLength++
            // 만났다고 처리해줌.
            map[relationship[currentPosition]] = true
            // 다음 만날 선배가 이제 만나는 중인 선배가 됨.
            currentPosition = relationship[currentPosition]
        }

        // 현재 선배를 통해 만날 수 있는 사람의 수가 이전 최고기록보다 높으면 갈아치움.
        if (currentPathLength > maxPathLength) {
            noOfBestElder = numOfElder
            maxPathLength = currentPathLength
        }
    }

    println(noOfBestElder)
}