import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[][] patterns = new int[][]{
            {1,2,3,4,5}
            ,{2,1,2,3,2,4,2,5}
            ,{3,3,1,1,2,2,4,4,5,5}
        };
        List<Integer> list = new ArrayList<>();
        int patternOneResult = recursion(0, patterns[0], answers);
        int patternTwoResult = recursion(0, patterns[1], answers);
        int patternThreeResult = recursion(0, patterns[2], answers);
        int maxNum = Math.max(patternOneResult, Math.max(patternTwoResult,patternThreeResult));
        if (patternOneResult == maxNum) list.add(1);
        if (patternTwoResult == maxNum) list.add(2);
        if (patternThreeResult == maxNum) list.add(3);

        answer = new int[list.size()];
        for (int i = 0;  i < answer.length; i++) answer[i] = list.get(i);
        return answer;
    }

    private int recursion(int index, int[] pattern, int[] answers) {
        if (index == answers.length) return 0;
        int correctNum = 0;
        if (answers[index] == pattern[index%pattern.length]) correctNum++;

        return correctNum + recursion(index+1, pattern, answers);
    }
}
