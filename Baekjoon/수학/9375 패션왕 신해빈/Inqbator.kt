import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    // 해빈이는 입었던 옷들은 다시 입지 않는다.
    // ex : 안경, 코트, 상의, 신발을 입었다면 다음날엔 바지를 추가로 입거나 || 안경 대신 렌즈를 착용해야 합니다.
    // 가진 의상들이 주어졌을 때 며칠동안 알몸이 아닌 상태로 돌아다닐 수 있을까.
    // 1 <= t(테스트 케이스 개수) <= 100
    // 0 <= n(옷 개수) <= 30

    // 방법 1
    // 입을 수 있는 부위 개수(cntOfWearPart)가 있으면 여기서 1개 고르기, 2개 고르기, 3개 고르기, ... , 입을 수 있는 부위 개수 다 고르기
    // 예 :
    // 머리 : 2
    // 눈 : 1
    // 머리 중에 1개 고르기(2) + 눈 중에 1개 고르기(1) + (머리 중에 1개 고르기(2) * 눈 중에 1개 고르기(1)) = 5
    // 즉, 몸에서 1개 고른 경우, 몸에서 2개 고른 경우, 몸에서 3개 고른 경우, .. , 몸에서 cntOfWearPart개 고른 경우.
    // 이 경우에 시간 복잡도는? O(t * n ^ n) => t * n ^ n = 100 * 2 ^ 30 => 너무 크다.

    // 방법 2
    // 전체 = 옷을 하나라도 입은 날 + 알몸인 날
    // 전체 - 알몸인 날 = 옷을 입은 날
    // 전체 = 옷들로 만들 수 있는 모든 조합 => 각 옷의 개수 + 1을 모두 곱한 값. + 1을 해주는 이유는 벗은 경우도 생각해서.
    // 옷을 입은 날 = (머리 옷의 개수 + 1) * (상의 옷의 개수 + 1) * ... * (신발 옷의 개수 + 1) - 1(알몸)
    val cntOfTest = readln().toInt()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val br = BufferedReader(InputStreamReader(System.`in`))
    repeat(cntOfTest) {
        val cntOfClothes = br.readLine().toInt()
        val map = mutableMapOf<String, Int>()
        repeat(cntOfClothes) {
            val st = StringTokenizer(br.readLine())
            st.nextToken()
            val part = st.nextToken()
            map[part] = map.getOrDefault(part, 0) + 1
        }
        bw.write("${getUnNakedDay(map)}\n")
    }
    bw.flush()
}

fun getUnNakedDay(map: MutableMap<String, Int>): Int {
    var unNakedDay = 1
    map.values.forEach {
        unNakedDay *= (it + 1)
    }

    return unNakedDay - 1
}