package BaekJoon.삼3의배수_1769;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try(final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String x = br.readLine();
            int conversionCount = 0;

            while(x.length() > 1) {
                char[] arr = x.toCharArray();
                int sum = 0;

                for (char c : arr) {
                    sum += c - '0';
                }

                x = String.valueOf(sum);
                conversionCount++;
            }

            System.out.printf("%d\n%s", conversionCount, Integer.parseInt(x) % 3 == 0 ? "YES" : "NO");
        }

    }
}
