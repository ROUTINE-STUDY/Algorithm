import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HwangInGyu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        int[] arrOfNums = new int[numbers.length];
        for (int i = 0; i < arrOfNums.length; i++) {
            arrOfNums[i] = Integer.parseInt(numbers[i]);
        }


        int number = getAlmostMultipleNumber(arrOfNums);
        System.out.println(number);
    }

    private static int getAlmostMultipleNumber(int[] arrOfNums) {
        int cntOfBaesoo = 0;
        int number;
        for (number = 1; number <= 1000000; number++) {
            for (int i = 0; i < arrOfNums.length; i++) {
                if (number%arrOfNums[i] == 0) {
                    cntOfBaesoo++;
                    if (cntOfBaesoo >= 3) {
                        return number;
                    }
                }
            }
            cntOfBaesoo = 0;
        }

        return -1;
    }
}