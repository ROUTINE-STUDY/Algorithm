import java.util.Arrays;

class Solution{
    public int solution(int []A, int []B){
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        for(int i=0; i<A.length; i++){
            answer += A[i] * B[A.length - i - 1]; // i가 0부터 시작이므로 -1을 해줘야 out of index 발생 X
        }
        
        return answer;
    }
}