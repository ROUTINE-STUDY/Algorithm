class Solution {
    public long solution(long n) {
        long answer = 0;
        if((Math.sqrt(n)*10)%10 == 0){
            answer = ((long)Math.sqrt(n)+1) * ((long)Math.sqrt(n)+1);
        }else{
            answer = -1;
        }
        return answer;
    }
}

// 2 조선시대 제곱근 구하는 방법

class Solution {
    public long solution(long nL) {
        long answer = 0;
        
        // 제곱근
        long root = 1;
        
        // 처음에 2로 나눔 double 형으로 바꿔야 함
        double n = (double)nL / 2;
        
        while(n > 0){
            if(n - root < 0){
                break;
            }
            n -= root;
            root++;
        }
        
        // 남은수의 2를 곱한 값이 while문을 돌린 횟수랑 같으면 제곱근, 아니면 -1
        if(n*2 != root){
            return -1;
        }
        
        answer = (root+1)*(root+1);
        
        return answer;
    }
}

// 3  Math.pow이용

class Solution {
    public long solution(long n) {
        
        double sqr = (int)Math.sqrt(n);
        // 만약 제곱근이 맞으면
        if(Math.pow(sqr,2) == n){
            return (long)Math.pow(sqr+1,2);
        } else{
            return -1;
        }
    }
}

// 3.1 삼항 연산자 체인지

class Solution {
    public long solution(long n) {
        double sqr = (int)Math.sqrt(n);
        // 만약 제곱근이 맞으면
        return Math.pow(sqr,2) == n ? (long)Math.pow(sqr+1,2) : -1;
    }
}