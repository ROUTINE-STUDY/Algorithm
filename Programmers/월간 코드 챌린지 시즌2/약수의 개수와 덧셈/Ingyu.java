class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        while (left <= right) {
            int numOfDivisor = 0;
            for (int j = 1; j <= left/2 + 1; j++) {
                if (left % j == 0) {
                    if (left/j == j) numOfDivisor += 1;
                    else numOfDivisor += 2;
                }
            }

            if (numOfDivisor % 2 ==0) answer += left;
            else answer -= left;
            left++;
        }

        return answer;
    }
}