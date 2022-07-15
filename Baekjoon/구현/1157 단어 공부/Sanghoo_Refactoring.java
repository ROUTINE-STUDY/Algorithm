package BaekJoon.단어공부_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo_Refactoring {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int[] alphaArray = new int[26];
            String word = br.readLine().toUpperCase();
            int max = 0;
            int maxIndex = 0;
            int count = 0;

            // 알파벳 카운팅
            for (char ch : word.toCharArray()) {
                alphaArray[ch - 65]++;
            }

            // 가장 많이 나온 알파벳, 인덱스 구하기
            for (int i = 0; i < alphaArray.length; i++) {
                if (alphaArray[i] > max) {
                    max = alphaArray[i];
                    maxIndex = i;
                } else if (alphaArray[i] == max) { // 같은게 나오면 "?" 로 지정
                    maxIndex = -2;
                }
            }

            System.out.println((char) (maxIndex + 65));
        }

    }

}
