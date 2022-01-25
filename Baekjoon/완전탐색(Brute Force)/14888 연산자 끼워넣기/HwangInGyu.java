import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HwangInGyu {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] arrOfNumbers;
    static int[] arrOfOperators = new int[4];
    private static boolean[] isExistNumber = new boolean[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cntOfNumbers = Integer.parseInt(br.readLine());
        arrOfNumbers = new int[cntOfNumbers];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < cntOfNumbers; i++) {
            arrOfNumbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arrOfOperators.length; i++) {
            int cntOfOperator = Integer.parseInt(st.nextToken());
            arrOfOperators[i] = cntOfOperator;
        }

        recursion(0, arrOfNumbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void recursion(int idxOfNumber, int sum) {
        if (idxOfNumber == arrOfNumbers.length-1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < arrOfOperators.length; i++) {
            if (arrOfOperators[i] == 0) {
                continue;
            }
            arrOfOperators[i] -= 1;
            switch (i) {
                case 0 :
                    recursion(idxOfNumber+1, sum + arrOfNumbers[idxOfNumber+1]);
                    break;
                // 연산자가 -
                case 1 :
                    recursion(idxOfNumber+1, sum - arrOfNumbers[idxOfNumber+1]);
                    break;
                // 연산자가 *
                case 2 :
                    recursion(idxOfNumber+1, sum * arrOfNumbers[idxOfNumber+1]);
                    break;
                case 3 :
                    recursion(idxOfNumber+1, sum / arrOfNumbers[idxOfNumber+1]);
                    break;
            }
            arrOfOperators[i] += 1;
        }
    }
}