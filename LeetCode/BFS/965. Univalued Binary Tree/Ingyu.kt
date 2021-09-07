import java.util.*

class Ingyu {
    fun isUnivalTree(root: TreeNode?): Boolean {
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.offer(root)
        val value = queue.peek().`val`

        while (!queue.isEmpty()) {
            val node = queue.poll()

            if (node.`val` != value) return false

            node.left?.let {
                queue.offer(node.left)
            }
            node.right?.let {
                queue.offer(node.right)
            }
        }
        return true
    }
}