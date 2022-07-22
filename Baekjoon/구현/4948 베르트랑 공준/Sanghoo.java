package BaekJoon.베르트랑공준_4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                int n = Integer.parseInt(br.readLine());
                int n2 = 2 * n;
                int result = 0;
                if (n == 0) break;

                boolean[] primeArray = new boolean[n2 + 1];
                Arrays.fill(primeArray, true); // 배열의 값을 모두 true 변경
                primeArray[0] = false;
                primeArray[1] = false;

                for (int i = 2; (i * i) <= n2; i++) {
                    if (primeArray[i]) {
                        for (int j = i * i; j <= n2; j += i) {
                            primeArray[j] = false;
                        }
                    }
                }

                for (int i = n + 1; i <= n2; i++) {
                    if (primeArray[i]) result++;
                }

                System.out.println(result);
            }

        }

    }

}
