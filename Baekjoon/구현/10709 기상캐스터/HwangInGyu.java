import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] map = new char[H][W];
        int[][] predictedCloudMap = new int[H][W];
        for (int row = 0; row < H; row++) {
            map[row] = br.readLine().toCharArray();
        }

        for (int row = 0; row < H; row++) {
            int columnPointOfNearestCloud = -1;
            for (int column = 0; column < W; column++) {
                if (map[row][column] == 'c') {
                    columnPointOfNearestCloud = column;
                    continue;
                }
                if (columnPointOfNearestCloud != -1) {
                    predictedCloudMap[row][column] = column - columnPointOfNearestCloud;
                } else {
                    predictedCloudMap[row][column] = -1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < H; row++) {
            for (int column = 0; column < W; column++) {
                sb.append(predictedCloudMap[row][column]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
