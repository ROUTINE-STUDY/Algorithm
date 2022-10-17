class Solution {
    public String solution(String s) {
		s = s.toLowerCase(); // 처음에 공백 제거
		
		String answer = String.valueOf(s.charAt(0)).toUpperCase();
		
		for(int i=1; i<s.length(); i++) {
			if(s.charAt(i-1) == ' ' && s.charAt(i) != ' '){
				answer += String.valueOf(s.charAt(i)).toUpperCase();
			}else {
				answer += s.charAt(i);
			}
		}
        
        return answer;
    }
}
