import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (cntOfNode, cntOfDegree, positionOfStartNode) = readLine().split(" ").map { it -> it.toInt() }
    val graph = Array<LinkedList<Int>>(cntOfNode) {LinkedList()}

    for (noOfDegree in 0 until cntOfDegree) {
        val (startNode, endNode) = readLine().split(" ").map { it.toInt()-1 }
        graph[startNode].add(endNode)
        graph[endNode].add(startNode)
    }

    graph.map { it.sort() }
    var isVisited = BooleanArray(cntOfNode)
    println(dfs(StringBuilder(), positionOfStartNode-1, graph, isVisited))
    isVisited = BooleanArray(cntOfNode)
    println(bfs(positionOfStartNode-1, graph, isVisited))
}

fun dfs(
    answer: StringBuilder,
    positionOfStartNode: Int,
    graph: Array<LinkedList<Int>>,
    visited: BooleanArray
): StringBuilder {
    if (visited[positionOfStartNode]) {
        return answer
    }

    visited[positionOfStartNode] = true
    answer.append(positionOfStartNode+1).append(" ")
    graph[positionOfStartNode].forEach { nextPosition ->
        answer.append(dfs(StringBuilder(), nextPosition, graph, visited))
    }

    return answer
}

fun bfs(
    positionOfStartNode: Int,
    graph: Array<LinkedList<Int>>,
    visited: BooleanArray
): StringBuilder {
    val sb = StringBuilder()
    val queue = LinkedList<Int>()
    sb.append(positionOfStartNode+1).append(" ")
    visited[positionOfStartNode] = true

    queue.offer(positionOfStartNode)
    while (!queue.isEmpty()) {
        val currentNode = queue.poll()

        graph[currentNode].forEach { nextNode ->
            if (!visited[nextNode]) {
                queue.offer(nextNode)
                sb.append(nextNode+1).append(" ")
                visited[nextNode] = true
            }
        }
    }

    return sb
}