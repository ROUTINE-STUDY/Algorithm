class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n+1];

        for (int i = 0; i <= n; i++) {
            String temp = Integer.toBinaryString(i);
            int numberOfOne = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '1') numberOfOne++;
            }
            answer[i] = numberOfOne;
        }

        return answer;
    }
}
