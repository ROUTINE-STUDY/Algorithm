class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int num = 0;
        
        for(int i=0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                num = i;
                break;
            }
        }
        answer = "김서방은 " + String.valueOf(num) + "에 있다";
        
        return answer;
    }
}