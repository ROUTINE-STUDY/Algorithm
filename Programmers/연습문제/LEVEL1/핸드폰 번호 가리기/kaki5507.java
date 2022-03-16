class Solution {
    public String solution(String phone) {
        String answer = "";
        for(int i=0; i<phone.length(); i++){
            if(4 >= phone.length()-i){
                answer += phone.charAt(i);
            }else{
                answer += "*";
            }
        }
        return answer;
    }
}