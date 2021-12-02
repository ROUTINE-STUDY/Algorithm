class Solution {
    public boolean solution(int x) {
        
        // String으로 변환
        String str = x+"";
        
        // 자릿수 합
        int hab=0;
        
        // x값 변환 안되게 tmp 사용
        int tmp = x;
        
        // 자릿수 hab에 누적해서 더해줌
        while(tmp > 0){
            hab += tmp%10;
            tmp = tmp/10;
        }
        
        // 나눴을때 나머지가 없으면 true를 리턴
        if(x % hab == 0){
            return true;
        }
        
        return false;
    }
}