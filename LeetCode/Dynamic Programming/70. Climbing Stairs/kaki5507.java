class Solution {
    public int climbStairs(int n) {
        // n==0,1,2,3 대신 return n으로 수정
        if(n < 4){
            return n;
        }
        
        int n2=2;
        int n3=3;
        int sum=0;
        
        // 0부터 시작 44까지
        for(int i=3; i<n; i++){
            sum = n2 + n3;
            n2 = n3;
            n3 = sum;
        }
        return sum;
        
        
        /*
            n=0 0
            n=1 1
            n=2 2
            n=3 3 
            n=4 5
            n=5 8 1 1 1 1 1/ 1 2 2 / 2 1 2 / 1 2 2 / 1 1 1 2 / 1 1 2 1 / 1 2 1 1 / 2 1 1 1 = 
            
            3은 1. + 2.
            4는 2. + 3.
            5는 3. + 4.
            
            피보나치 수열
        */
    }
}