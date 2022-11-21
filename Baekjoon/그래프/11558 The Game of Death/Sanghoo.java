package BaekJoon.TheGameOfDeath_11558;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int TEST_CASE = Integer.parseInt(br.readLine());

            for (int i = 0; i < TEST_CASE; i++) {
                final int N = Integer.parseInt(br.readLine());
                int result = 1;
                int[] targets = new int[N + 1];
                boolean[] visited = new boolean[N + 1];

                for (int j = 1; j <= N; j++) {
                    targets[j] = Integer.parseInt(br.readLine());
                }

                int target = targets[1];
                while (target != N) {
                    result++;

                    if (visited[target]) {
                        result = 0;
                        break;
                    }

                    visited[target] = true;
                    target = targets[target];
                }
                System.out.println(result);
            }

        }

    }
}
