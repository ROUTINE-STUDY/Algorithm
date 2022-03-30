import java.io.BufferedReader
import java.io.InputStreamReader

var cnt = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var X = readLine()
    val outputNum = getCntOfLoop(X)

    println(cnt)
    if (outputNum % 3 == 0) println("YES")
    else println("NO")
}

fun getCntOfLoop(X: String): Int {
    if (X.length < 2) {
        return X.toInt()
    }

    var x = StringBuilder(X)
    var temp = 0
    while (x.length > 1) {
        cnt++
        for (i in x.length-1 downTo 0) {
            temp += x[i].digitToInt()
        }

        x = StringBuilder(temp.toString())
        temp = 0
    }

    return temp
}
