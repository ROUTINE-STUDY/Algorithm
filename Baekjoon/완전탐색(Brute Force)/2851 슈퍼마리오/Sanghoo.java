package BaekJoon.슈퍼마리오_2851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int GOAL_SCORE = 100;
            int[] scores = new int[10];
            int[] diffScores = new int[10];
            int sum = 0, result = 0;

            // 누적 점수와 목표 점수와의 차이를 각 배열의 담음
            for (int i = 0; i < 10; i++) {
                sum += Integer.parseInt(br.readLine());
                scores[i] = sum;
                diffScores[i] = Math.abs(sum - GOAL_SCORE);
            }

            // 정렬(절대값으로 저장했으므로 가장 가까운 값이 0번지)
            Arrays.sort(diffScores);

            // 98 - 104 와 같이 같은 차이를 보이는 케이스가 존재하고 - 큰 수를 고른다 했으므 처리
            if(diffScores[0] == diffScores[1]) {
                result = diffScores[1] + GOAL_SCORE;
            } else {
                // 0번지의 합계 값을 찾아 처리
                for(int score : scores) {
                    if(score == diffScores[0] + GOAL_SCORE) {
                        result = score;
                    }
                }
                result = (result > 0) ? result : GOAL_SCORE - diffScores[0];
            }

            System.out.println(result);
        }

    }

}
