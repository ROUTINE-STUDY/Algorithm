package Greedy.Lemonade_Change;

/**
 * https://leetcode.com/problems/lemonade-change/
 */
public class Sanghoo {

    // 무지성 조건문..
    public static boolean lemonadeChange(int[] bills) {

        if(bills[0] > 5) return false;  // 첫 주문부터 10원권 이상을 내면 거슬러 줄 돈이 없어요,,
        int[] moneys = new int[3];      // 돈을 담는 배열

        for(int b : bills) {
           if(b == 5) moneys[0]++;      // 5원은 무조건 적립!
           else if(b == 10) {           // 10원
               if(moneys[0] < 1) {      // 5원이 한 장도 없다면 false
                   return false;
               }
               moneys[0]--;
               moneys[1]++;
           } else {                     // 20원
               if(moneys[0] >= 1 && moneys[1] >= 1) {   // 10원 5원 최소 한 장씩, 10원을 가지고 있다면 우선 소모 하기 위해 첫 번째 if문에 위치
                   moneys[0]--;
                   moneys[1]--;
                   moneys[2]++;
               } else if(moneys[0] >= 3){               // 5원 최소 3장
                   moneys[0] -= 3;
                   moneys[2]++;
               } else {                                 // 거슬러 주지 못합니당..
                   return false;
               }
           }
        }

        return true;
    }

    public static void main(String[] args) {
//        int[] bills = {5,5,5,10,20};
        int[] bills = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        System.out.println(lemonadeChange(bills));
    }
}
