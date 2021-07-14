import java.util.*

class Solution {
    fun deepestLeavesSum(root: TreeNode?): Int {
        var sum: Int = 0;
        val q: Queue<TreeNode> = LinkedList<TreeNode>()
        q.offer(root)

        while (!q.isEmpty()) {
            //시작하면 매번 값을 0으로 초기화해서.
            //이전 층의 결과가 이어지지 않게함.
            sum = 0;
            //현재 계층의 요소 구하기.
            var numOfCurrentDepth = q.size
            while (numOfCurrentDepth-- > 0) {
                val temp: TreeNode = q.poll()
                sum += temp.`val`

                temp.left?.let {q.offer(it)}
                temp.right?.let {q.offer(it)}
            }
        }

        return sum
    }
}
