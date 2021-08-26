class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int gcd = getGCD(Math.max(str1.length(), str2.length()), Math.min(str1.length(), str2.length()));
        String answer = str1.substring(0, gcd);

        for (int i = 0; i <= str1.length()-gcd; i+=gcd) {
            if (!str1.substring(i, i+gcd).equals(answer)) {
                return "";
            }
        }
        for (int i = 0; i <= str2.length()-gcd; i+=gcd) {
            if (!str2.substring(i, i+gcd).equals(answer)) {
                return "";
            }
        }

        return answer;
    }

    public int getGCD(int a, int b) {
        while(b > 0) {
            int tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
    }
}