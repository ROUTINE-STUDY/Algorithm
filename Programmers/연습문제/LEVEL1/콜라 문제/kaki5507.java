class Solution {
    public int solution(int a, int b, int n) {
        int recCoke = 0;
        int answer = 0; // 9

        while(n >= a){
            recCoke = n / a * b; // 받은 코카
            n = n - ( n - n % a ) + (recCoke);
            answer += recCoke;
        }
        
        return answer;
    }
}