import java.util.Arrays;



public class IngyuBinary {
    static class Solution {
        public int[] countBits(int n) {
            int[] answer = new int[n+1];

            for (int i = 0; i <= n; i++) {
                int temp = i;

                int numberOfOne = 0;
                do {
                    numberOfOne += temp % 2;
                    temp /= 2;
                } while (temp > 0);

                answer[i] = numberOfOne;
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("ss");
        s.countBits(5);
    }
}