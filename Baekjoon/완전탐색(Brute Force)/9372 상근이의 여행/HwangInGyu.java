import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HwangInGyu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cntOfTestcases = Integer.parseInt(br.readLine());

        // for문 반복 한 번에 테스트 케이스 1개씩
        for (int noOfTestcase = 1; noOfTestcase <= cntOfTestcases; noOfTestcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            List<Integer>[] map = new LinkedList[N];

            int head = 0;
            // 연결 여부처리
            for (int noOfM = 1; noOfM <= M; noOfM++) {
                st = new StringTokenizer(br.readLine(), " ");
                int startCity = Integer.parseInt(st.nextToken()) - 1;
                int endCity = Integer.parseInt(st.nextToken()) - 1;
                head = startCity;

                if (map[startCity] == null) {
                    map[startCity] = new LinkedList();
                }
                map[startCity].add(endCity);

                if (map[endCity] == null) {
                    map[endCity] = new LinkedList();
                }
                map[endCity].add(startCity);
            }

            int distance = 0;
            boolean[] isVisited = new boolean[N];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(head);
            isVisited[head] = true;

            while (!queue.isEmpty()) {
                int noOfCountry = queue.poll();
                for (int noOfNextCity : map[noOfCountry]) {
                    if (!isVisited[noOfNextCity]) {
                        queue.offer(noOfNextCity);
                        isVisited[noOfNextCity] = true;
                        distance++;
                    }
                }
            }

            System.out.println(distance);
        }
    }
}