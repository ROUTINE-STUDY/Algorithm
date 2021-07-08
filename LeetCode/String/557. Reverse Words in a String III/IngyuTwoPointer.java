class Solution1 {
    public String reverseWords(String s) {
        char[] reversedString = new char[s.length()];

        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int end = 0;

            if (s.charAt(i) == ' ') {
                end = i-1;
                swap(start,end,s,reversedString);
                reversedString[i] = ' ';
                start = i+1;
            } else if (i == s.length()-1) {
                end = i;
                swap(start,end,s,reversedString);
                start = i+1;
            }
        }

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