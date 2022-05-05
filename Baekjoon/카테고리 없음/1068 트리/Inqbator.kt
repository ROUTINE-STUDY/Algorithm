import java.io.BufferedReader
import java.io.InputStreamReader

var cntOfLeafNode = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val cntOfNode = readLine().toInt()
    val tree = MutableList(cntOfNode) { MutableList(0) { 0 } }
    var rootNode = -1
    val input = readLine().split(" ").map { it.toInt() }
    // 루트 노드 : 자식이 없는 노드들
    val listOfRoot = MutableList(0) {0}

    for (childNo in input.indices) {
        val parentNo = input[childNo]
        if (parentNo == -1) {
            listOfRoot.add(childNo)
            continue
        }

        tree[parentNo].add(childNo)
    }

    // 지울 노드 번호
    val removedNodeNo = readLine().toInt()
    tree.forEach { ints ->
        ints.remove(removedNodeNo)
        removeNodeRecursively(removedNodeNo = removedNodeNo, tree = tree)
    }
    listOfRoot.remove(removedNodeNo)

    listOfRoot.forEach { node ->
        cntLeafNode(tree, tree[node])
    }
    println(cntOfLeafNode)
}

fun cntLeafNode(tree: MutableList<MutableList<Int>>, list: MutableList<Int>) {
    if (list.size == 0) {
        cntOfLeafNode++
        return
    }

    list.forEach { node ->
        cntLeafNode(tree, tree[node])
    }
}


fun removeNodeRecursively(removedNodeNo: Int, tree: MutableList<MutableList<Int>>) {
    if (tree[removedNodeNo].size == 0) {
        return
    }

    tree[removedNodeNo].forEach { child ->
        removeNodeRecursively(removedNodeNo = child, tree = tree)
    }
    tree[removedNodeNo].clear()
}

