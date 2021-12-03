class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        // 둘 중 더 작은거까지 조사
        int small = Math.min(n,m);
        //최대공약수
        for(int i=1; i<=small; i++){
            if(n%i == 0 && m%i == 0){
                answer[0] = i;
            }
        }
        
        answer[1] = (n * m) / answer[0];
        return answer;
    }
}