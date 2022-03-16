import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        // 빈 배열인 경우 -1 리턴
        if(arr.length <= 1){
            int[] answer = {-1};
            return answer;
        }
        
        //하나 뺀 값의 크기
        int[] answer = new int[arr.length-1];
        
        // 제일 작은 수 if문으로도 가능
        int small = arr[0];
        for(int i=0; i<arr.length; i++){
            small = Math.min(small,arr[i]);
        }
        
        // count로 answer은 차례차례 넣어준다
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == small){
                continue;
            }else{
                answer[count++] = arr[i];
            }
        }
        
        return answer;
    }
}