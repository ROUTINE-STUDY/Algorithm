class Solution {
    public int maximum69Number (int num) {
        int answer = num;
        int number = 1000;
        while (number > 0) {
            if (num / number == 6) {
                break;
            }

            num %= number;
            number /= 10;
        }
        answer += 3*number;

        return answer;
    }
}