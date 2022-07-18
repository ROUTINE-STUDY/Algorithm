package BaekJoon.단어뒤집기_9093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                String[] words = br.readLine().split(" ");
                StringBuilder sb = new StringBuilder();

                for (String word : words) {
                    sb.append(new StringBuilder(word).reverse().append(" "));
                }

                System.out.println(sb);
            }
        }

    }

}
