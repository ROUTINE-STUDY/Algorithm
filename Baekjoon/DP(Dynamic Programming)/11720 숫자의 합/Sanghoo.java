package BaekJoon.숫자의합_11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String N = br.readLine();
            String str = br.readLine();
            int result = 0;

            for(char ch : str.toCharArray()) {
                result += Integer.parseInt(String.valueOf(ch));
            }

            System.out.println(result);
        }

    }

}
