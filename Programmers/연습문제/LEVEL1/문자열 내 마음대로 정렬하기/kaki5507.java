import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        // n의 문자를 맨 앞에 저장
        for(int i=0; i<strings.length; i++){
            answer[i] = strings[i].charAt(n) + strings[i];
        }
        
        // 정렬 하면 맨 앞과 동시에 원래 string도 정렬이 됨
        Arrays.sort(answer);
        
        // 맨 앞에 substring1을 통해서 지워줌
        for(int i=0; i<strings.length; i++){
            answer[i] = answer[i].substring(1);
        }
        
        return answer;
    }
}