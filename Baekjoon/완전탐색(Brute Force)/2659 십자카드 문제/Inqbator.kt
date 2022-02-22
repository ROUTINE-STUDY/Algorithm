import java.io.BufferedReader
import java.io.InputStreamReader

var idx = 0
val isVisited = BooleanArray(10000)
var targetNumber = 0

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))){
    val inputs = readLine().split(" ").map {it.toInt()}
    var number = inputs[0]*1000+inputs[1]*100+inputs[2]*10+inputs[3]
    targetNumber = makeClockCount(number)

    println((recursion(number, 0,0)))
}

fun makeClockCount(number: Int): Int {
    var temp = number
    var minNum = number
    // 나머지와 나누기로 1자리씩 이동하기
    repeat(3) {
        temp = temp % 1000 * 10 + temp / 1000
        if(minNum > temp) minNum = temp
    }
    return minNum
}

fun recursion(number: Int, currentNumber: Int, currentIdx: Int): Int {
    if (currentIdx == 4) {
        val clockCount = makeClockCount(currentNumber)

        if (!isVisited[clockCount]) {
            idx++
            isVisited[clockCount] = true
            if (clockCount == targetNumber) {
                return idx
            }
        }

        return -1
    }

    for (i in 1..9) {
        var addedNum = 1000
        repeat(currentIdx) {
            addedNum /= 10
        }

        if (recursion(number, currentNumber + addedNum*i, currentIdx+1) != -1) {
            return idx
        }
    }

    return -1
}