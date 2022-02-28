import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.absoluteValue

// 거리의 총합
var answer = Int.MAX_VALUE
// 지도의 가로세로 크기
var size = 0
// 폐업할 가게 개수
var cntOfDeletedTarget = 0
// 폐업한 가게를 저장할 set
val setOfDeletedChickens = HashSet<Int>()
// 집의 위치를 담은 리스트
val listOfHome = ArrayList<IntArray>()
// 치킨 집의 위치를 담은 리스트
val listOfChicken = ArrayList<IntArray>()
// 집에서 각 치킨집까지의 거리를 담을 배열
lateinit var homeToChicken: Array<IntArray>


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 입력
    val (N,M) = readLine().split(" ").map { it.toInt() }
    size = N
    cntOfDeletedTarget = M

    repeat(N) { row ->
        val st = StringTokenizer(readLine()," ")
        var column = 0
        while (st.hasMoreTokens()) {
            when (st.nextToken().toInt()) {
                1 -> listOfHome.add(intArrayOf(row, column))
                2 -> listOfChicken.add(intArrayOf(row, column))
            }
            column++
        }
    }

    // 각 가게에서 각 치킨칩까지의 모든 거리를 구함.
    // row는 집 번호, column은 치킨 가게 번호
    homeToChicken = Array(listOfHome.size) {IntArray(listOfChicken.size)}
    for (row in homeToChicken.indices) {
        for (column in homeToChicken[row].indices) {
            homeToChicken[row][column] = (listOfHome[row][0] - listOfChicken[column][0]).absoluteValue + (listOfHome[row][1] - listOfChicken[column][1]).absoluteValue
        }
    }

    // 가게 폐업 시키기
    deleteMChickenShop(0, 0)
    println(answer)
}

// 가게 폐업 시키기
fun deleteMChickenShop(cntOfCurrentDeleted: Int, currentIdx: Int) {
    // if : 가게를 다 폐업시켰으면
    if (cntOfCurrentDeleted == cntOfDeletedTarget) {
        // 치킨도시의 거리를 최솟값으로 갱신
        answer = answer.coerceAtMost(getTotalDistance(setOfDeletedChickens))
        return
    }

    for (idx in currentIdx until listOfChicken.size) {
        if (setOfDeletedChickens.contains(idx)) {
            continue
        }

        setOfDeletedChickens.add(idx)
        deleteMChickenShop(cntOfCurrentDeleted+1, idx+1)
        setOfDeletedChickens.remove(idx)
    }
}

// 폐업한 가게를 제외한 거리의 총합의 최솟값을 구하기
fun getTotalDistance(setOfDeletedChickens: HashSet<Int>): Int {
    var totalDistance = 0
    for (row in 0 until listOfHome.size) {
        var distance = Int.MAX_VALUE
        for (column in 0 until listOfChicken.size) {
            // 폐업하지 않은 치킨집이면 거리를 더 작은 값으로 갱신
            if (setOfDeletedChickens.contains(column)) {
                distance = homeToChicken[row][column].coerceAtMost(distance)
            }
        }

        // 폐업하지 않은 가게 중에, 가장 가까운 거리를 총 거리에 더함.
        totalDistance += distance
    }

    return totalDistance
}
