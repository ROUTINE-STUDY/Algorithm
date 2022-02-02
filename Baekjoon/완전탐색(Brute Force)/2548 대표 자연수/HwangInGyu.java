import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HwangInGyu {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cntOfNumbers = Integer.parseInt(br.readLine());
        int[] arrOfNumbers = new int[cntOfNumbers];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < cntOfNumbers; i++) {
            arrOfNumbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrOfNumbers);

        int answer = 0;
        if (cntOfNumbers % 2 == 0) {
            answer = arrOfNumbers[cntOfNumbers/2-1];
        } else {
            answer = arrOfNumbers[cntOfNumbers/2];
        }
        System.out.println(answer);
    }
}