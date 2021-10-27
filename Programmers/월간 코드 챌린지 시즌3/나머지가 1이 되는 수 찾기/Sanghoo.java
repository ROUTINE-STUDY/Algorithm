package Programmers.나머지1이되는수찾기;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/87389
 */
public class Sanghoo {

    public int solution(int n) {
        int answer = 0;

        for(int i=2; i<n; i++) {
            if(n%i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }

}
