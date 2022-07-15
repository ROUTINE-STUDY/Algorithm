package BaekJoon.단어공부_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo {

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
                }
            }

            // 가장 많이 나온 알파벳이 몇 번 나왔는지 카운팅
            for (int alphaCount : alphaArray) {
                if (max == alphaCount) {
                    count++;
                }
            }

            // 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 "?", 이 외는 해당 알파벳
            String result = (count > 1) ? "?" : Character.toString((char) (maxIndex + 65));
            System.out.println(result);
        }

    }

}
