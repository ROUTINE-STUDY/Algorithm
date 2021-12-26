class Solution {
    public int[] solution(long n) {
        String tmp = n+"";
        
        int[] answer = new int[tmp.length()];
        
        int count = 0;
        while(n > 0){
            answer[count] = (int)(n % 10);
            n = n / 10;
            count++;
        }
        
        return answer;
    }
}