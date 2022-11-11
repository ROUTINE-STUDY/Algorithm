class Solution {
    fun solution(food: IntArray): String {
        var answer = StringBuilder()
        var length = 0
        for (i in 1 until food.size) {
            length += food[i] / 2
            food[i] /= 2
        }
        length *= 2
        length += 1

        val charArray = Array(length) { ' ' }
        charArray[length / 2] = '0'
        var pointer = 1
        for (i in 0 until length / 2) {
            if (food[pointer] == 0) {
                while (food[pointer] == 0) {
                    pointer++
                }
            }

            charArray[i] = pointer.digitToChar()
            charArray[charArray.size - i - 1] = pointer.digitToChar()
            food[pointer]--
        }
        charArray.forEach { answer.append(it) }

        return answer.toString()
    }
}