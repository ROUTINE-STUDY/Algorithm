import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

val bw = BufferedWriter(OutputStreamWriter(System.out))
class Tree(var rootNode: Node?) {
    fun createNode(rootData: Char, lData: Char, rData: Char) {
        if (rootNode != null) {
            return
        }
        rootNode = Node(rootData, null, null)
        if (lData != '.') {
            rootNode!!.left = Node(lData, null, null)
        }
        if (rData != '.') {
            rootNode!!.right = Node(rData, null, null)
        }
    }

    fun addNode(rootData: Char, lData: Char, rData: Char) {
        // rootData를 찾음
        val node = rootNode?.let { searchNode(it, rootData) }
        node?.let {
            if (lData != '.') {
                node.left = Node(lData, null, null)
            }
            if (rData != '.') {
                node.right = Node(rData, null, null)
            }
        }
    }

    // startNode부터 재귀 탐색을 통해 data와 일치하는 node를 리턴한다
    private fun searchNode(startNode: Node, data: Char): Node? {
        var result: Node? = null
        if (startNode == null) {
            return null
        } else if (startNode.data == data) {
            return startNode
        }

        startNode.left?.let {
            result =  searchNode(it, data)
        }
        result?.let { return result }

        startNode.right?.let {
            result = searchNode(it, data)
        }

        return result
    }

    fun preOrder(node: Node) {
        bw.write(node.data.toString())
        if (node.left != null) {
            preOrder(node.left!!)
        }
        if (node.right != null) {
            preOrder(node.right!!)
        }
    }

    // 중위 순회
    fun inOrder(node: Node) {
        node.left?.let {
            inOrder(it)
        }
        bw.write(node.data.toString())
        node.right?.let {
            inOrder(it)
        }
    }

    // 후위 순회
    fun postOrder(node: Node) {
        node.left?.let {
            postOrder(it)
        }
        node.right?.let {
            postOrder(it)
        }
        bw.write(node.data.toString())
    }
}

class Node(val data: Char, var left: Node?, var right: Node?)
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cntOfNode = br.readLine().toInt()
    var st = StringTokenizer(br.readLine())
    // 루트 노드 만들기
    val tree = Tree(null)
    tree.createNode(st.nextToken()[0], st.nextToken()[0], st.nextToken()[0])

    // 트리 만들기
    repeat(cntOfNode - 1) {
        st = StringTokenizer(br.readLine())
        tree.addNode(st.nextToken()[0], st.nextToken()[0], st.nextToken()[0])
    }

    tree.rootNode?.let { rootNode ->
        tree.preOrder(rootNode)
        bw.write("\n")
        bw.flush()
        tree.inOrder(rootNode)
        bw.write("\n")
        bw.flush()
        tree.postOrder(rootNode)
        bw.write("\n")
        bw.flush()
    }
}