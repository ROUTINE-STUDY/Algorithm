import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int a[] = {1,2,3,4,5};
        int b[] = {2,1,2,3,2,4,2,5};
        int c[] = {3,3,1,1,2,2,4,4,5,5};
        
        int score[] = {0,0,0};
        for(int i=0; i<answers.length; i++){
            if(a[i%5] == answers[i]){
                score[0]++;
            }
            if(b[i%8] == answers[i]){
                score[1]++;
            }
            if(c[i%10] == answers[i]){
                score[2]++;
            }
        }
        
        // 최고 점수
        int best =  Math.max(score[0],Math.max(score[1],score[2]));
        
        ArrayList<Integer> arr = new ArrayList();
        
        // i+1을 해줘야지 1,2,3 이렇게 가능
        for(int i=0; i<score.length; i++){
            if(best == score[i]){
                arr.add(i+1);
            }
        }
        
        int[] answer = new int[arr.size()];
        
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}