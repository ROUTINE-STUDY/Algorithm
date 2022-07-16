package BaekJoon.소수찾기_1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int N = Integer.parseInt(br.readLine());
            final String[] NUM_ARRAY = br.readLine().split(" ");
            int primeCount = 0;

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(NUM_ARRAY[i]);
                boolean isPrime = true;

                // 소수 체크 (1보다 큰 자연수 중 1과 자기 자신만을 약수로 가지는 수)
                if (num == 1) {
                    continue;
                }

                for (int j = 2; j < num; j++) {
                    if (num % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    primeCount++;
                }

            }

            System.out.println(primeCount);
        }

    }

}
