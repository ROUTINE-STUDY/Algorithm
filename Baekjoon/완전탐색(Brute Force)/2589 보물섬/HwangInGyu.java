import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HwangInGyu {
    static int width;
    static int height;
    static char[][] map;
    static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        map = new char[height][width];
        for (int i = 0; i < height; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int distance = Integer.MIN_VALUE;
        for (int idxOfHeight = 0; idxOfHeight < height; idxOfHeight++) {
            for (int idxOfWidth = 0; idxOfWidth < width; idxOfWidth++) {
                if (map[idxOfHeight][idxOfWidth] == 'L') {
                    boolean[][] isVisited = new boolean[height][width];
                    distance = Math.max(distance, bfs(isVisited, idxOfHeight, idxOfWidth));
                }
            }
        }
        System.out.println(distance);
    }

    private static int bfs(boolean[][] isVisited, int idxOfHeight, int idxOfWidth) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{idxOfHeight, idxOfWidth});
        int distance = -1;
        while (!q.isEmpty()) {
            int cntOfSameDepth = q.size();

            for (int i = 0; i < cntOfSameDepth; i++) {
                int[] currentLocation = q.poll();
                isVisited[currentLocation[0]][currentLocation[1]] = true;
                for (int[] direction : directions) {
                    int[] nextLocation = new int[]{currentLocation[0] + direction[0], currentLocation[1]+direction[1]};
                    if (0 <= nextLocation[0] && nextLocation[0] < height && 0 <= nextLocation[1] && nextLocation[1] < width) {
                        if (isVisited[nextLocation[0]][nextLocation[1]]) {
                            continue;
                        }
                        if (map[nextLocation[0]][nextLocation[1]] == 'L') {
                            q.offer(nextLocation);
                            isVisited[nextLocation[0]][nextLocation[1]] = true;
                        }
                    }
                }
            }
            distance++;
        }
        return distance;
    }

}