class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        boolean flag = true;
        
        // 같은 값 있는지 비교
        for(int i=0; i< words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    answer[0] = j % n + 1;
                    answer[1] = j / n + 1;
                    flag = false;
                }
            }
            
            if(flag && i > 0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                flag = false;
                break;
            }
        }
        
        
        if(flag){return new int[]{0,0};}
        
        return answer;
    }
}