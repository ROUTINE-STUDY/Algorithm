class Solution {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root?.left == null && root?.right == null ) return 0
        var answer = 0
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.offer(root)

        while (!queue.isEmpty()) {
            val node = queue.poll()

            node.left?.also { left ->
                queue.offer(left)
                if (left.left == null && left.right == null) answer += left.`val`
            }
            node.right?.also { right -> queue.offer(right) }
        }

        return answer
    }
}