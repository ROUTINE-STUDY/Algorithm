import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int answer[];
        int[] correctNum = new int[3];
        int[][] pattern = new int[][]{
                {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5},
                {2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5,2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5,3,3,1,1,2,2,4,4,5,5}
        };
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            int patternIdx = i%pattern[0].length;
            if (answers[i] == pattern[0][patternIdx]) correctNum[0]++;
            if (answers[i] == pattern[1][patternIdx]) correctNum[1]++;
            if (answers[i] == pattern[2][patternIdx]) correctNum[2]++;
        }

        int max = Math.max(correctNum[0],Math.max(correctNum[1],correctNum[2]));
        for (int i = 0; i < correctNum.length; i++)
            if (correctNum[i] == max) list.add(i);

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i) + 1;

        return answer;
    }
}