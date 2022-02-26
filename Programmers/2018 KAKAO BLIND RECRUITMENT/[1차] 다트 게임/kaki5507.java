import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
		int answer=0;
		// 48~57 0~9임
		
        int dRleng = dartResult.length(); // 다트 문자열 길이        
        int[] round = new int[4]; // 라운드 총 3 , 마지막에 문자열 마지막 길이를 넣어준다.
        int[] roundScore = new int[3]; // 라운드 스코어
        
        int rNum = 0; // 현재 라운드
        for(int i=0; i<dRleng; i++){
            if(dartResult.charAt(i) > 47 && dartResult.charAt(i) < 58){ // 0 ~ 9
                if(dartResult.charAt(i) == (char)49 && dartResult.charAt(i+1) == (char)48){ // 10인 경우
                    round[rNum] = i;
                    i++;
                } else { // 10아닐때
                    round[rNum] = i;
                }
                rNum++;
            } 
        }
        round[3] = dRleng;
        
        
        // 총 3라운드 진행
        for(int i=0; i<3; i++) {
        	int tmp = 0; // 계산을 하기 위한 tmp
        	for(int j=round[i]; j<round[i+1]; j++) {
        		int acha = 0; // 아차상 구하기
        		
        		if(dartResult.charAt(j) > 47 && dartResult.charAt(j) < 58) { // 숫자면 ~
        			if(dartResult.charAt(j) == (char)49 && dartResult.charAt(j+1) == (char)48) { // 10이면
        				tmp=10;
        				j++;
        			}else { // 0~9이면
        				tmp = dartResult.charAt(j) - '0';
        				System.out.println(tmp);
        			}
        		}else if(dartResult.charAt(j) == 'D') {
        			tmp = tmp*tmp;
        		} else if(dartResult.charAt(j) == 'T') {
        			tmp = tmp*tmp*tmp;
        		} else if(dartResult.charAt(j) == '*') {
        			if(i > 0) {
        				roundScore[i-1] = roundScore[i-1] * 2;
        			}
        			tmp = tmp*2;
        		} else if(dartResult.charAt(j) == '#') {
        			if(acha > 0) {
        				roundScore[acha] = roundScore[acha] * -1;
        			}
        			tmp = tmp * -1;
        			acha++; // 아차상 +1
        		}
        	}
        	roundScore[i] = tmp;
        }
        
        for(int i=0; i<3; i++) {
        	answer+=roundScore[i];
        }
        return answer;
    }
}