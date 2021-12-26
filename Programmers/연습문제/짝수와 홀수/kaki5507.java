class Solution {
    public String solution(int num) {
        String answer = "";
        if(num % 2 == 0){
            answer = "Even";
        }else{
            answer ="Odd";
        }
        return answer;
    }
}


// 삼항 연산자

class Solution {
    public String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}