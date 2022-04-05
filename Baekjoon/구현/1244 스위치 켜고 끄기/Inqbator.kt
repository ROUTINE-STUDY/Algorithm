import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cntOfSwitch = readLine().toInt()
    val statusOfSwitches = readLine().split(" ").map { when(it) {
        "1" -> true
        else -> false
    } }.toBooleanArray()
    val cntOfStudents = readLine().toInt()

    for (i in 1..cntOfStudents) {
        val (noOfGender, num) = readLine().split(" ").map { it.toInt() }
        if (num-1 !in statusOfSwitches.indices) {
            continue
        }

        when (noOfGender) {
            1 -> changeMultipleSwitch(statusOfSwitches, num-1)
            2 -> changeSymmetrySwitch(statusOfSwitches, num-1)
        }
    }

    val sb = StringBuilder()
    statusOfSwitches.forEachIndexed { index, it ->
        if (it) {
            sb.append(1)
        } else {
            sb.append(0)
        }
        sb.append(" ")
        if ((index+1) % 20 == 0) {
            sb.append("\n")
        }
    }

    sb.deleteCharAt(sb.length-1)
    println(sb)
}

fun changeMultipleSwitch(statusOfSwitches: BooleanArray, num: Int) {
    var multipliedNum = 1
    while ((num+1)*(multipliedNum)-1 in statusOfSwitches.indices) {
        statusOfSwitches[(num+1)*multipliedNum-1] = !statusOfSwitches[(num+1)*multipliedNum-1]
        multipliedNum++
    }
}

fun changeSymmetrySwitch(statusOfSwitches: BooleanArray, num: Int) {
    statusOfSwitches[num] = !statusOfSwitches[num]

    var left = num-1
    var right = num+1
    while (0 <= left && right <= statusOfSwitches.size-1) {
        if (statusOfSwitches[left] == statusOfSwitches[right]) {
            statusOfSwitches[left] = !statusOfSwitches[left]
            statusOfSwitches[right] = !statusOfSwitches[right]
            left--
            right++
        } else {
            break
        }
    }
}