import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        //BFS 구현을 위해, Queue를 선언.
        Queue<TreeNode> q = new LinkedList<>();
        //헤드를 먼저 넣어줌.
        q.offer(root);

        //BFS
        //반복문을 나와도 값의 유지를 위해 밖에 선언한 각 계층의 총합을 위한 변수.
        int sum = 0;
        while (!q.isEmpty()) {
            //시작하면 매번 값을 0으로 초기화해서.
            //이전 층의 결과가 이어지지 않게함.
            sum = 0;
            //현재 계층의 요소 구하기.
            int numOfCurrentDepth = q.size();
            while (numOfCurrentDepth-- > 0) {
                TreeNode temp = q.poll();
                sum += temp.val;

                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            }
        }

        return sum;
    }
}