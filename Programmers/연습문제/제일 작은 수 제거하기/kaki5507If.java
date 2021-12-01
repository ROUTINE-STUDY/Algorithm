import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length <= 1){
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[arr.length-1];
        
        int small = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= small){
                small = arr[i];
            }
        }
        
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == small){
                continue;
            }else{
                answer[count] = arr[i];
                count++;
            }
        }
        
        return answer;
    }
}