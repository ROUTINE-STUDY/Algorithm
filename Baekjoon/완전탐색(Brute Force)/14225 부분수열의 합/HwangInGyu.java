import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HwangInGyu {
    private static boolean[] isExistNumber = new boolean[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sizeOfNumbers = Integer.parseInt(br.readLine());
        int[] arrOfNumbers = new int[sizeOfNumbers];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < sizeOfNumbers; i++) {
            arrOfNumbers[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        checkPossibleNum(arrOfNumbers, 0, 0);
        for (int i = 1; i < isExistNumber.length; i++) {
            if (!isExistNumber[i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    // 만들 수 있는 숫자는 방문처리
    private static void checkPossibleNum(int[] arrOfNumbers, int index, int sum) {
        if (index == arrOfNumbers.length) {
            return;
        }

        // 현재 숫자를 더했을 경우,
        isExistNumber[sum+arrOfNumbers[index]] = true;
        checkPossibleNum(arrOfNumbers, index+1, sum+arrOfNumbers[index]);
        // 현재 숫자를 더하지 않았을 경우
        isExistNumber[sum] = true;
        checkPossibleNum(arrOfNumbers, index+1, sum);
    }
}