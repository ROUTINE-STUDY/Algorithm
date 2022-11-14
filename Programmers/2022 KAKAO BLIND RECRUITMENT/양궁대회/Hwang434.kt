class Solution {
    val answer = IntArray(11)
    var scoreDiffrence = 0

    fun solution(n: Int, info: IntArray): IntArray {
        recursion(info, IntArray(11), 0, n)

        return if (scoreDiffrence == 0) {
            intArrayOf(-1)
        } else {
            var cntOfArrow = 0
            answer.forEach { cntOfArrow += it }
            if (cntOfArrow != n) {
                answer[10] += n - cntOfArrow
            }

            answer
        }
    }

    private fun recursion(apacheShotInfo: IntArray, lionShotInfo: IntArray, idx: Int, remainArrowCnt: Int) {
        if (idx >= 11 || remainArrowCnt == 0) {
            var currentApacheScore = 0
            var currentLionScore = 0
            for (i in 0..10) {
                if (apacheShotInfo[i] > lionShotInfo[i]) {
                    currentApacheScore += 10 - i
                } else if (apacheShotInfo[i] < lionShotInfo[i]) {
                    currentLionScore += 10 - i
                } else {
                    if (apacheShotInfo[i] == 0) {
                        continue
                    }
                    currentApacheScore += 10 - i
                }
            }

            if (scoreDiffrence < currentLionScore - currentApacheScore) {
                scoreDiffrence = currentLionScore - currentApacheScore
                for (i in 0..10) {
                    answer[i] = lionShotInfo[i]
                }
            } else if (scoreDiffrence == currentLionScore - currentApacheScore) {
                for (i in 10 downTo 0) {
                    if (answer[i] > lionShotInfo[i]) {
                        return
                    } else if (answer[i] < lionShotInfo[i]) {
                        scoreDiffrence = currentLionScore - currentApacheScore
                        for (i in 0..10) {
                            answer[i] = lionShotInfo[i]
                        }
                    }
                }
            }
            return
        }

        recursion(apacheShotInfo, lionShotInfo, idx + 1, remainArrowCnt)
        if (remainArrowCnt > apacheShotInfo[idx]) {
            if (remainArrowCnt > apacheShotInfo[idx]) {
                lionShotInfo[idx] = apacheShotInfo[idx] + 1
                recursion(apacheShotInfo = apacheShotInfo, lionShotInfo = lionShotInfo, idx + 1, remainArrowCnt - apacheShotInfo[idx] - 1)
            }
        }
        lionShotInfo[idx] = 0
    }
}