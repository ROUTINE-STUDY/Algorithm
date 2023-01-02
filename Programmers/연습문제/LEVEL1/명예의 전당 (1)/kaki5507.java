import java.util.*;
import java.util.List;
import java.util.Collections;

public class Fame {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(3,new int[]{10, 100, 20, 150, 1, 100, 200}));
    }

}
class Solution{
    public int[] solution(int k, int[] score){
        int[] answer = new int[score.length];

        List<Integer> hall = new ArrayList<Integer>();

        for(int i=0; i<score.length; i++){
            if(i < k){ // 0 1 2 3
                hall.add(score[i]);
                hall.sort(Collections.reverseOrder());
            }else{
                hall.add(score[i]);
                hall.sort(Collections.reverseOrder());
                hall.remove(hall.size());
            }
            answer[i] = hall.get(hall.size() - 1);
        }
        System.out.println(Arrays.toString(answer));

        return answer;
    }
}