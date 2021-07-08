import java.util.Arrays;

class Solution {
    public String reverseWords(String s) {
        char[] reversedString = new char[s.length()];

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                end = i-1;
                swap(start,end,s,reversedString);
                reversedString[i] = ' ';
                start = i+1;
            }
        }

        swap(start, s.length()-1, s, reversedString);

        return new String(reversedString);
    }

    private void swap(int start, int end,String original, char[] reversedString) {
        while (start <= end) {
            reversedString[start] = original.charAt(end);
            reversedString[end] = original.charAt(start);

            start++;
            end--;
        }
    }
}