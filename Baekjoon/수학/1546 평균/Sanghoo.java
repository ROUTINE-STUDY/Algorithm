package BaekJoon.평균_1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int N = Integer.parseInt(br.readLine());
            String[] scores = br.readLine().split(" ");
            double maxScore = getMaxScore(scores);
            double calcScore = getCalcScore(scores, maxScore);

            System.out.println(calcScore / N);
        }

    }

    /**
     *  최대값 가져오기
     */
    private static double getMaxScore(String[] scores) {
        double maxScore = 0;

        for (String score : scores) {
            maxScore = Math.max(Integer.parseInt(score), maxScore);
        }

        return maxScore;
    }

    /**
     * 조작 성적 계산 합계
     */
    private static double getCalcScore(String[] scores, double maxScore) {
        double totalScore = 0;

        for (String score : scores) {
            totalScore += (Double.parseDouble(score) / maxScore) * 100;
        }

        return totalScore;
    }
}
