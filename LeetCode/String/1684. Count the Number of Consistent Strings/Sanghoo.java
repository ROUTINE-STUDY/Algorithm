package String.Count_the_Number_of_Consistent_Strings;

/**
 * https://leetcode.com/problems/count-the-number-of-consistent-strings/
 */
public class Sanghoo {

    // 1. 정규표현식을 이용한 방식
    public int countConsistentStrings(String allowed, String[] words) {
        int result = 0;

        for(String word : words) {
            if(word.matches("^[" + allowed + "]*$")) {
                result++;
            }
        }
        return result;
    }

    // 2. 반복문 및 contains 메서드 이용
    public int countConsistentStrings_2(String allowed, String[] words) {
        int result = 0;

        for(String word : words) {
            boolean isContain = true;

            for(char ch : word.toCharArray()) {
                if(!allowed.contains(String.valueOf(ch))) {
                    isContain = false;
                    break;
                }
            }

            if(isContain) result++;
        }
        return result;
    }

}
