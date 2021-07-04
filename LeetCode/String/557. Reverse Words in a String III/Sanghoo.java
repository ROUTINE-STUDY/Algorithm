package String.Reverse_Words_in_a_String_III;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class Sanghoo {

    // StringBuilder의 reverse() 메서드 활용
    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder res = new StringBuilder();

        for(int i=0; i<arr.length; i++) {
            StringBuilder sb = new StringBuilder(arr[i]);
            res.append(sb.reverse()).append(" ");
        }

        res.deleteCharAt(res.length()-1);

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "I love u";
        System.out.println(reverseWords(s));
    }
}
