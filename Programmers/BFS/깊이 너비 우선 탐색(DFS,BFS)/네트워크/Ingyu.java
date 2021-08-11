import java.util.LinkedList;
import java.util.Queue;

class Solution {
    //boolean형 배열을 통한 코드.
    public int solution(int n, int[][] computers) {
        boolean[] visitedIndex = new boolean[n];        //컴퓨터들의 방문 여부를 체크하기 위한 boolean 배열.
        Queue<int[]> queue = new LinkedList<>();        //BFS 구현을 위해 만든 큐.
        int answer = 0;                                    //네트워크의 개수.

        for (int i = 0; i < computers.length; i++) {    //네트워크의 시작 기준을 queue에 넣어줄 반복문.
            if (visitedIndex[i] == true) {                //방문한 컴퓨터면 다음 컴퓨터로 넘어간다.
                continue;
            }

            queue.offer(computers[i]);                    //네트워크의 시작점이 될 컴퓨터를 queue에 넣어줌.
            visitedIndex[i] = true;                        //시작점은 이제 방문했으므로 방문 여부 true.
            while (!queue.isEmpty()) {                    //시작점과 연결된 모든 컴퓨터의 검색이 끝날 때까지 계속.
                int[] computer = queue.poll();            //시작점 컴퓨터를 뽑아줌.

                for (int j = 0; j < computer.length; j++) {        //연결된 컴퓨터들을 모두 queue에 넣어줌.
                    if (j == i || visitedIndex[j] == true) continue;
                    if (computer[j] == 1) {
                        visitedIndex[j] = true;
                        queue.offer(computers[j]);
                    }
                }
            }
            answer++;                                    //시작점과 이어진 모든 컴퓨터의 검색이 끝났으므로, 네트워크 개수 증가.
        }

        return answer;
    }
}