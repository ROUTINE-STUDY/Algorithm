import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> tmpArr = new ArrayList();
        
        int saveNum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != saveNum){
                saveNum = arr[i];
                tmpArr.add(arr[i]);
            }
        }
        
        int[] answer = new int[tmpArr.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = tmpArr.get(i);
        }
        
        return answer;
    }
}