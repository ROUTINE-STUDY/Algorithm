import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HwangInGyu {
    static int cntOfMushrooms = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arrOfScores = new int[cntOfMushrooms];
        for (int i = 0; i < cntOfMushrooms; i++) {
            arrOfScores[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(getNumberNearToHundred(arrOfScores,0,0));
    }

    private static int getNumberNearToHundred(int[] arrOfScores, int start, int end) {
        if (end > cntOfMushrooms-1) {
            return 0;
        }

        int sum1 = 0;
        for (int i = start; i <= end; i++) {
            sum1 += arrOfScores[i];
        }
        if (sum1 == 100) {
            return sum1;
        }

        int sum2 = getNumberNearToHundred(arrOfScores, start, end+1);
        if (Math.abs(100-sum1) < Math.abs(100-sum2)) {
            return sum1;
        } else if (Math.abs(100-sum1) > Math.abs(100-sum2)){
            return sum2;
        } else {
            return sum1 > sum2 ? sum1 : sum2;
        }
    }
}