class Solution {
    public String solution(String phone) {
        String answer = "";
        
        for(int i=0; i<phone.length()-4; i++){
            answer += "*";
        }
        
        answer += phone.substring(phone.length()-4);
        
        return answer;
    }
}