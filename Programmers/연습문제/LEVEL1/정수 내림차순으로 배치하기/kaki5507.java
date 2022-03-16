import java.util.Arrays;

class Solution {
    public long solution(long n) {
        // 문자형으로 반환
        String str = String.valueOf(n);
        // Char 배열에 넣기 위해 배열 생성
        char[] ch = new char[str.length()];
        
        // 정답 answer
        String answerStr = "";
        
        for(int i=0; i<str.length(); i++){
            ch[i] = str.charAt(i);
        }
        
        Arrays.sort(ch);
        
        for(int i=str.length()-1; i>=0; i--){
            answerStr += ch[i];
        }
        long answer = Long.parseLong(answerStr);
        
        return answer;
    }
}



//다른 사람 코드 내껄로 만들기
import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        StringBuilder sb = new StringBuilder(new String(ch,0,ch.length));
        
        return Long.parseLong(sb.reverse().toString());
    }
}
