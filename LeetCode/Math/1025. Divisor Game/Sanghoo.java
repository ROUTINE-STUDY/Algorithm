package Math.Divisor_Game;

/**
 *  https://leetcode.com/problems/divisor-game/
 */
public class Sanghoo {

    // Alice가 첫 번째로 무조건 시작하는데, 2명이서 turn제 게임이면 짝수면 무조건 Alice 승리 아닌가?
    public static boolean divisorGame(int n) {
        return  (n%2 == 0) ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(divisorGame(3));
    }
}
