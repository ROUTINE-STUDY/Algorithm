package Array.Plus_One;

/**
 * https://leetcode.com/problems/plus-one/
 */
public class Sanghoo {

    public static int[] plusOne(int[] digits) {
        // 끝자리가 9라면 계산 필요
        if(digits[digits.length-1] == 9) {
            // 뒤에서부터 9의 개수 카운팅
            int cnt = 0;
            for(int i=digits.length-1; i>=0; i--) {
                if(digits[i] == 9) cnt++;
                else break;
            }

            // 요소 모두 9라면 배열의 길이 증가 필요, 맨 앞에만 1로 바꿔주고 int[] 기본값은 0
            if(cnt == digits.length) {
                int[] arr = new int[digits.length+1];
                arr[0] = 1;
                return arr;
            } else {    // 모두 9가 아니라면 요소 앞은 +1이 되고 뒷자리는 0으로 변경
                int len = digits.length-1;
                while(cnt >= 0) {
                    if(cnt == 0)  {
                        digits[len]++; break;
                    }
                    digits[len] = 0;
                    --len; --cnt;
                }
                return digits;
            }
        } else {
            digits[digits.length-1]++;
            return digits;
        }

    }

}
