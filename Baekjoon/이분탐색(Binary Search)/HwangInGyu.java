import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = bfr.readLine().split(" ");
        // 나무의 개수
        int N = Integer.parseInt(firstLine[0]);
        // 필요한 나무의 길이
        int M = Integer.parseInt(firstLine[1]);
        // 나무 배열
        int[] trees = new int[N];
        String[] secondLine = bfr.readLine().split(" ");
        for (int i = 0; i < secondLine.length; i++) {
            trees[i] = Integer.parseInt(secondLine[i]);
        }
        Arrays.sort(trees);

        int start = 0;
        int end = trees[N-1];
        while (start+1 < end) {
            long sum = 0;
            int mid = (start + end)/2;
            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) sum += trees[i] - mid;
            }

            if (sum >= M) start = mid;
            else end = mid;
        }
        System.out.println(start);
    }
}