package BFS.Network;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */
public class Sanghoo {

    // 자주 풀던 BFS 로직에 탐색체크 로직 추가 풀이
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visitChecks = new boolean[n];
        Queue<int[]> q = new LinkedList<>();

        // 기존 BFS처럼 ROOT부터 전체 탐색하는게 아니라 각각의 컴퓨터(Node)를 순회해야함
        for(int i=0; i<computers.length; i++) {
            if(visitChecks[i]) continue;

            q.offer(computers[i]);
            visitChecks[i] = true;

            while(!q.isEmpty()) {
                int[] computer = q.poll();

                for(int j=0; j<computer.length; j++) {
                    if(!visitChecks[j] && computer[j] == 1) {
                        q.offer(computers[j]);
                        visitChecks[j] = true;
                    }
                }
            }
            answer++;
        }

        return answer;
    }

}
