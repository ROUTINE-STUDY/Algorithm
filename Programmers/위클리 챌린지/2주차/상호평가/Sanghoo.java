package Programmers.상호평가;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/83201
 */
public class Sanghoo {

    // 학생별 점수를 담기위한 Map
    Map<Integer, List<Integer>> scoreMap = new HashMap<>();

    public String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();

        // 1. 각 학생이 받은 전체 점수들을 map을 통해 저장합니다. (key : 학생, value : 해당학생이 받은 점수)
        setBasicScore(scores);

        for(int i=0; i < scores.length; i++) {
            List<Integer> scoreList = scoreMap.get(i);
            int selfScore = scoreList.get(i);

            // 2. 스스로에게 준 점수가 유일한 최고/최저점인지 확인한 후 true 라면 해당 점수를 제거합니다.
            if(isRemoveMyScore(scoreList, selfScore)) scoreList.remove(i);
            // 3. 점수 목록을 가지고 평균값을 구한 뒤 점수에 해당하는 등급을 구합니다.
            answer.append(getGrade(scoreList));
        }

        return answer.toString();
    }

    /**
     * 학생별로 점수를 map에 저장하는 메서드(key : 학생명(숫자), value : 자신의 점수 list)
     */
    public void setBasicScore(int[][] scores) {
        for(int i=0; i<scores.length; i++) {
            List<Integer> score = new ArrayList<>();
            for(int j=0; j<scores[i].length; j++) {
                score.add(scores[j][i]);
            }
            scoreMap.put(i, score);
        }
    }

    /**
     * 자신에게 준 점수가 유일한 최고점 또는 최저점인지 반환하는 메서드
     */
    public boolean isRemoveMyScore(List<Integer> scoreList, int selfScore) {
        int count = 0;
        int min = Collections.min(scoreList);
        int max = Collections.max(scoreList);

        if(selfScore == min || selfScore == max) {
            for(int score : scoreList) {
                if(score == selfScore || score == selfScore) count++;
            }
        }

        return (count == 1) ? true : false;
    }

    /**
     * 점수들의 평균을 구한 뒤 평균에 해당하는 등급을 반환하는 메서드
     */
    public String getGrade(List<Integer> scoreList) {
        String grade = "";
        double sum = 0;
        double avg = 0.0;

        // 평균 구하기
        for(int score : scoreList) {
            sum += score;
        }
        avg = sum/scoreList.size();

        // 등급 구하기
        if(avg >= 90) grade = "A";
        else if(avg >= 80 && avg < 90) grade = "B";
        else if(avg >= 70 && avg < 80) grade = "C";
        else if(avg >= 50 && avg < 70) grade = "D";
        else grade = "F";

        return grade;
    }
}
