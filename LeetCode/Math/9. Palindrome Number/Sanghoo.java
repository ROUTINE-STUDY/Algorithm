package Math.Palindrome_Number;

/**
 * https://leetcode.com/problems/palindrome-number/
 */
public class Sanghoo {

    // 1. 연산을 통한 방법
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        int originNumber = x;
        int revertedNumber = 0;

        while(originNumber > 0) {
            revertedNumber = revertedNumber * 10 + originNumber % 10;
            originNumber /= 10;
        }

        return x == revertedNumber;
    }

    // 2. StringBuilder reverse 메서드 활용
    public boolean isPalindrome_2(int x) {
        String str = String.valueOf(x);
        StringBuilder sb = new StringBuilder(str);

        return sb.reverse().toString().equals(str) ? true : false;
    }

    // 3.양 끝값 비교하는 방법
    public boolean isPalindrome_3(int x) {
        String str = String.valueOf(x);

        // 양 끝값 비교이므로 절반만 반복
        for(int i=0; i<str.length()/2; i++) {
            char head = str.charAt(i);
            char tail = str.charAt(str.length()-1-i);

            if(head != tail) return false;
        }

        return true;
    }

}
