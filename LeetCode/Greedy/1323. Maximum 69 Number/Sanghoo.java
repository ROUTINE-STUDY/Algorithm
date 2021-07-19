package Greedy.Maximum_69_Number;

/**
 * https://leetcode.com/problems/maximum-69-number/
 */
public class Sanghoo {

    /**
     * 문제 내 1 <= num <= 10^4 인 점을 활용
     * 제일 큰 자리수로 6이 나오면 그 수를 바꿔주면 끝
     * 99699 > 99699 + 300 = 99999
     */
    public int maximum69Number (int num) {
        int res = num;

        int x = 10000;
        while(num > 0) {
            if(num/x == 6) {
                res += x*3;
                break;
            }
            num = num%x;
            x /= 10;
        }

        return res;
    }

}
