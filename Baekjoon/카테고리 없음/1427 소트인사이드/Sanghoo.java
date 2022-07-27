package BaekJoon.소트인사이드_1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String n = br.readLine();

            char[] array = n.toCharArray();
            Arrays.sort(array);

            StringBuilder sb = new StringBuilder(new String(array));
//            StringBuilder sb = n.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).reverse();
            System.out.println(sb.reverse());

        }

    }

}
