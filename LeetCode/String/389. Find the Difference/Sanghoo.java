package String.Find_the_Difference;

/**
 * https://leetcode.com/problems/find-the-difference/
 */
public class Sanghoo {

    // 기존 많이 사용했던 알파벳별 개수를 이용하였습니다.
    public char findTheDifference(String s, String t) {
        char res = '0';
        int[] arr = new int[26];

        for(int i=0; i<t.length(); i++) {
            if(i < s.length()) {
                arr[s.charAt(i)-'a']++;
            }
            arr[t.charAt(i)-'a']--;
        }

        for(int i=0; i<arr.length; i++) {
            if(arr[i] < 0) {
                res = (char)(i+'a');
                break;
            }
        }

        return res;
    }

}
