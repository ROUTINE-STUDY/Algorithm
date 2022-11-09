package Programmers.문자열내맘대로정렬하기;

import java.util.Arrays;

public class Sanghoo {

    public static void main(String[] args) {
        solution(new String[]{"sun", "bed", "car"}, 1);
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            char c1 = s1.charAt(n);
            char c2 = s2.charAt(n);

            return (c1 == c2) ? s1.compareTo(s2) : c1 - c2;
        });

        return strings;
    }
}
