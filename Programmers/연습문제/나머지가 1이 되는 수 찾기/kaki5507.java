class Solution {
    public int solution(int n) {
        int answer = n;
        
        for(int i=1; i<=n; i++){
            if(n % i == 1){
                answer = Math.min(answer, i);
            }
        }
        
        return answer;
    }
}