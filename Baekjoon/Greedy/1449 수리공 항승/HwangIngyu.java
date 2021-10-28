import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        int sumOfTape = 0;
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] nl = bfr.readLine().split(" ");

        // 테이프의 길이(자연수)
        int n = Integer.parseInt(nl[0]);
        int l = Integer.parseInt(nl[1]);
        String[] pipeHole = bfr.readLine().split(" ");
        int[] pipeHolePoint = new int[pipeHole.length];
        for (int i = 0; i < n; i++) {
            pipeHolePoint[i] = Integer.parseInt(pipeHole[i]);
        }
        Arrays.sort(pipeHolePoint);

        int startPoint = pipeHolePoint[0];
        boolean isTaped = false;
        for (int i = 1; i < n; i++) {
            if (pipeHolePoint[i] - startPoint >= l) {
                sumOfTape++;
                startPoint = pipeHolePoint[i];
                isTaped = true;
            }
            isTaped = false;
        }

        if (!isTaped) sumOfTape++;
        System.out.println(sumOfTape);
    }
}