package BaekJoon.세로읽기_10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] arr = new String[5];
            StringBuilder sb = new StringBuilder();
            int maxLength = 0;

            for (int i = 0; i < 5; i++) {
                arr[i] = br.readLine();
                maxLength = Math.max(maxLength, arr[i].length());
            }

            for (int i = 0; i < maxLength; i++) {
                for (String str : arr) {
                    if (i < str.length()) {
                        sb.append(str.charAt(i));
                    }
                }
            }

            System.out.println(sb);
        }

    }

}
