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

            for (int i = 0; i < 10; i++) {
                sum += Integer.parseInt(br.readLine());
                scores[i] = sum;
                diffScores[i] = sum - GOAL_SCORE;
            }

            int difference = Integer.MAX_VALUE;
            // 정렬을 하지않고 순회하면서 최소값을 찾음
            for (int i = 0; i < diffScores.length; i++) {
                int currentDifference = Math.abs(diffScores[i]);
                if (difference > currentDifference) {   // 작은 값일 시 교체
                    difference = currentDifference;
                    result = diffScores[i] + GOAL_SCORE;
                } else if (difference == currentDifference) { // 같은데 기존 result가 더 작다면 교체(문제에서 큰 수를 고르기 때문)
                    if (result < diffScores[i] + GOAL_SCORE) {
                        result = diffScores[i] + GOAL_SCORE;
                    }
                }
            }

            System.out.println(result);
        }

    }

}
