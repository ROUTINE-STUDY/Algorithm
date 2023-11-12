package Programmers.숫자의표현;

public class Sanghoo {

    public static void main(String[] args) {
        solution(15);
    }

    public static int solution(int n) {
        int answer = 1;

        for (int i = 1; i < n; i++) {
            int sum = i;

            for (int j = i + 1; j < n; j++) {
                sum += j;

                if (sum > n) break;
                if (sum == n) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

}
