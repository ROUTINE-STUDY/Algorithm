package BaekJoon.소수찾기_1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo_Refactoring {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int N = Integer.parseInt(br.readLine());
            final String[] NUM_ARRAY = br.readLine().split(" ");
            int primeCount = 0;
            boolean isPrime;

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(NUM_ARRAY[i]);

                isPrime = checkPrimeNumber(num);

                if (isPrime) {
                    primeCount++;
                }
            }

            System.out.println(primeCount);
        }

    }

    // 소수 체크 (1보다 큰 자연수 중 1과 자기 자신만을 약수로 가지는 수)
    public static boolean checkPrimeNumber(int num) {
        if (num == 1) {
            return false;
        }

        for (int j = 2; j * j <= num; j++) { // 자신의 루트값 이하의 수로 나눠지지 않으면 그 수는 소수
            if (num % j == 0) {
                return false;
            }
        }

        return true;
    }

}
