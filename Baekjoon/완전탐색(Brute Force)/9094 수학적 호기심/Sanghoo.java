package BaekJoon.수학적호기심_9094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Sanghoo {

    static int[][] case;

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int testCaseCount = Integer.parseInt(br.readLine());
            case = new int[testCaseCount][];

            // 입력과 로직을 분리 안했다..
            for(int i=0; i<testCaseCount; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                case[i] = {n,m};

                System.out.println(case[i]);
//                System.out.println(calculate(n,m));
            }
        }

    }

    private static int calculate(int n, int m) {
        int integerCount = 0;
        double result = 0;

        for(int a=1; a<n-1; a++) {
            for(int b=a+1; b<n; b++) {
                result = ((pow(a,2)+ pow(b,2) +m) / (a*b));

                if(result == (int) result) integerCount++;
            }
        }
        return integerCount;
    }

}
