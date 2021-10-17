import java.util.*

class Solution {
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        val answer = LinkedList<List<Int>>()
        arr.sort()

        var pivot = Integer.MAX_VALUE
        for (i in 0..arr.size-2) {
            if (arr[i+1] - arr[i] < pivot) pivot = arr[i+1] - arr[i]
        }

        for (i in 0..arr.size-2) {
            if (arr[i+1] - arr[i] == pivot) {
                val list = LinkedList<Int>()
                list.add(arr[i])
                list.add(arr[i+1])
                answer.add(list)
            }
        }

        return answer
    }
}