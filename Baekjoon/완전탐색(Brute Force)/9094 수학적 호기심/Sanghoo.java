package BaekJoon.수학적호기심_9094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sanghoo {

    static int[][] testCase;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            int testCaseCount = Integer.parseInt(br.readLine());
            testCase = new int[testCaseCount][];

            // 입력
            for(int i=0; i<testCaseCount; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                testCase[i] = new int[]{n,m};
            }

            // 구현
            for(int i=0; i<testCaseCount; i++) {
                int n = testCase[i][0];
                int m = testCase[i][1];

                sb.append(calculate(n,m)).append("\n");
            }
            System.out.println(sb);
        }
    }

    private static int calculate(int n, int m) {
        int integerCount = 0;
        double result;

        for(double a=1; a<n-1; a++) {
            for(double b=a+1; b<n; b++) {
                result = (a*a + b*b + m) / (a*b);
                if(result == (int) result) integerCount++;
            }
        }
        return integerCount;
    }

}
