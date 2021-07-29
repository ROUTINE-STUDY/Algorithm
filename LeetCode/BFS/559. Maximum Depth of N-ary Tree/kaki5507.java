/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        // Node 타입을 받는 q를 만들어 줍니다.
        Queue<Node> q = new LinkedList<>();
        
        // root를 q에다가 담아줍니다.
        q.offer(root);
        
        // 깊이를 세어줄 count를 만들어 줍니다.
        int count = 0;
        
        // q가 비어있을떄 까지 돌려줍니다.
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int i=0; i<size; i++){
                Node node = q.poll();
                for(Node nextNode : node.children){
                    q.offer(nextNode);
                }
            }
        }
        return count;
    }
}