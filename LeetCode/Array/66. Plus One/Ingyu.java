import java.util.Arrays;

class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1]++;
        for (int i = digits.length - 1; i >= 1; i--) {
            if (!(digits[i] == 10)) {
                return digits;
            }
            digits[i] = 0;
            ++digits[i-1];
        }

        if (digits[0] == 10) {
            digits[0] = 0;
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newDigits[i+1] = digits[i];
            }

            digits = newDigits;
        }

        return digits;
    }
}
