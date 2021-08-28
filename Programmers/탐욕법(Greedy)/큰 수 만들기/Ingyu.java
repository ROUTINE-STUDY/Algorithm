class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);

        int i = 0;
        while (k > 0) {
            if (sb.charAt(i) < sb.charAt(i+1)) {
                sb.deleteCharAt(i);
                if (i > 0) i--;
                else i = 0;

                k--;
            } else {
                i++;
            }

            if (i == number.length()-1) break;
        }

        if (k > 0) sb.delete(sb.length()-k,sb.length());

        return sb.toString();
    }
}