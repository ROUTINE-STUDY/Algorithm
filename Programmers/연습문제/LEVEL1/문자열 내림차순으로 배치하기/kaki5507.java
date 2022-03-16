import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        for(int i=ch.length; i>0; i--){
            answer += ch[i-1];
        }
        
        return answer;
    }
}

// for문 부분 살짝 변경 가능
/*
        for(int i=ch.length-1; i>=0; i--){
            answer += ch[i];
        }
*/

// 2 StringBuilder

import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new StringBuilder(new String(ch,0,ch.length)).reverse().toString();
    }
}