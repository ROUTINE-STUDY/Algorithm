import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HwangInGyu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cntOfTestcases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cntOfTestcases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int answer = getNumOfSatisfiedInt(n, m);
            System.out.println(answer);
        }
    }

    private static int getNumOfSatisfiedInt(int n, int m) {
        int answer = 0;
        for (int a = 1; a <= n-2; a++) {
            for (int b = a+1; b <= n-1; b++) {
                if ((a*a+b*b+m)%(a*b) == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}