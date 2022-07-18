package BaekJoon.소수_2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // M ~ N 자연수 중 소수
            final int M = Integer.parseInt(br.readLine());
            final int N = Integer.parseInt(br.readLine());
            int minPrimeNumber = -1;
            int sumPrimeNumber = 0;

            boolean[] primeArray = new boolean[N + 1];
            Arrays.fill(primeArray,true); // 배열의 값을 모두 true 변경
            // 0, 1은 소수 제외
            primeArray[0] = false;
            primeArray[1] = false;

            for (int i = 2; (i * i) <= N; i++) { // N이 120이면 11^2 > 120 이므로 11보다 작은 수의 배수들만 지워도 충분
                if (primeArray[i]) { // 소수면 해당 소수의 배수를 모두 false 변경
                    for (int j = i * i; j <= N; j += i) {
                        primeArray[j] = false;
                    }
                }
            }

            // 배열을 역순으로 순회하여 최소 소수를 찾고, 범위는 M 까지
            for (int i = primeArray.length - 1; i >= M; i--) {
                if (primeArray[i]) {
                    sumPrimeNumber += i;
                    minPrimeNumber = i;
                }
            }

            if (minPrimeNumber == -1) {
                System.out.println(minPrimeNumber);
            } else {
                System.out.println(sumPrimeNumber + "\n" + minPrimeNumber);
            }

        }

    }
}
