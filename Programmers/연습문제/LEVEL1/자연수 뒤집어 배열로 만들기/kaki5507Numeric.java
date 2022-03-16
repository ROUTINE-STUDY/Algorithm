import java.util.Arrays;

class Solution {
    public int[] solution(long n) {
        String tmp = Long.toString(n);
        
        int[] answer = new int[tmp.length()];
        
        int count=0;
        for(int i=tmp.length()-1; i>=0; i--){
            answer[count] = Character.getNumericValue(tmp.charAt(i));
            count++;
        }
        
        return answer;
    }
}