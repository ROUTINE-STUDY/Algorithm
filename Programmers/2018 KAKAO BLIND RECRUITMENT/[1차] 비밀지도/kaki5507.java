class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[] map = new int[n];
        
        // or 비트 연산
        for(int i=0; i<n; i++){
            map[i] = arr1[i] | arr2[i];
        }
        
        for(int i=0; i<map.length; i++){
            String tmp = Integer.toBinaryString(map[i]); // 이진법 변환
            //1001 > 01001 로 출력되게 해야함 n까지 앞에 "0"대입
            while(tmp.length() < n){
                tmp = "0"+tmp;
            }
            tmp = tmp.replaceAll("0"," "); //0은 공백으로
            tmp = tmp.replaceAll("1","#"); //1은 #으로 변환
            answer[i] = tmp;
        }
        
        return answer;
    }
}