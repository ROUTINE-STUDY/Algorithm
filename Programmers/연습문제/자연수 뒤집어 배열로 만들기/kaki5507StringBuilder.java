import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder(s);
        
        // sb 거꾸로
        // sb = sb.reverse();
        sb.reverse();
        
        int[] answer = new int[sb.length()];
        
        String[] sbStr = sb.toString().split("");
        
        for(int i=0; i<sb.length(); i++){
            answer[i] = Integer.parseInt(sbStr[i]);
        }
        
        
        return answer;
    }
}