import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> winNumberSet = new HashSet<>();
        //Set의 당첨 번호 넣기
        for (int win_num : win_nums) { winNumberSet.add(win_num); }     

        // 지워진 번호의 개수
        int erasedCnt = 0;
        // 총 지워진 개수와, 지워진 개수를 다 틀렸다고 가정했을 때 맞은 개수 구하기.
        for (int lotto : lottos) {
            if (lotto == 0) erasedCnt++;
            if (winNumberSet.contains(lotto)) answer[0]++;
        }
        // answer[1]은 지워진 숫자는 다 틀렸다고 봤을 때
        answer[1] = answer[0];
        // answer[0]은 지워진 숫자가 다 맞았다고 봤을 때
        answer[0] += erasedCnt;

        // getRanking 메서드를 이용하여, 등수 구하기
        answer[0] = getRanking(answer[0]);
        answer[1] = getRanking(answer[1]);
        return answer;
    }

    // 등수를 리턴하는 메서드
    private int getRanking(int correctCnt) {
        int ranking = 0;
        switch (correctCnt) {
            case 6:
                ranking = 1;
                break;
            case 5:
                ranking = 2;
                break;
            case 4:
                ranking = 3;
                break;
            case 3:
                ranking = 4;
                break;
            case 2:
                ranking = 5;
                break;
            default:
                ranking = 6;
        }

        return ranking;
    }
}
