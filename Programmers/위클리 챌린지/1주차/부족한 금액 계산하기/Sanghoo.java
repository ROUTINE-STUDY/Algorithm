package Programmers.부족한금액계산하기;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/82612
 */
public class Sanghoo {

    public long solution(int price, int money, int count) {
        long answer = -1;
        int totalPrice = 0;

        for(int i=1; i<=count; i++) {
            totalPrice += price * i;
        }

        answer = totalPrice > money ? totalPrice-money : 0;
        return answer;
    }

}
