package BaekJoon.단어의개수_1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sanghoo {

    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] wordArr = br.readLine().trim().split(" ");
            System.out.print(wordArr[0].equals("") ? 0 :wordArr.length);

            // Stream 사용
            String[] wordArrStream = br.readLine().split(" ");
            System.out.print(Arrays.stream(wordArrStream).filter(word -> !word.equals("")).count());
        }
    }

}
