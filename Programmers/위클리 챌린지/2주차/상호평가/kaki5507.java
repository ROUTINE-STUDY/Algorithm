import java.util.*;

class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        
        
        for(int i=0; i<scores.length; i++){
            int grade = 0;
            int big = -1;
            int small = 101;
            int count = 0;
            boolean unique = true;
            for(int j=0; j<scores[i].length; j++){
                
                small = Math.min(scores[j][i], small);
                big = Math.max(scores[j][i], big);
                
                if(i != j && scores[i][i] == scores[j][i]){
                    unique = false;
                }
                
                grade += scores[j][i];
                count++;
            }
            
            if(unique && (big == scores[i][i] || small == scores[i][i])){
                grade -= scores[i][i];
                count--;
            }
            
            grade = grade / count;
            
            if (grade >= 90.0f){answer += "A";}
            else if (grade >= 80.0f){answer += "B";}
            else if (grade >= 70.0f){answer += "C";}
            else if (grade >= 50.0f){answer += "D";}
            else answer += "F";
        }
        
        return answer;
    }
}