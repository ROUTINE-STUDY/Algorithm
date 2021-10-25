package Programmers.없는숫자더하기;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/86051
 */
public class Sanghoo {

    public int solution(int[] numbers) {
        int answer = 45;

        for(int number : numbers) {
            answer -= number;
        }

        return answer;
    }

}
