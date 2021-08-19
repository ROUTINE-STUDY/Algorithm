package String.Greatest_Common_Divisor_of_Strings;

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 */
public class Sanghoo {

    // replaceAll 사용
    public String gcdOfStrings(String str1, String str2) {
        String res = "";

        for(int i=str2.length(); i>0; i--) {
            String regex = str2.substring(0, i);

            String temp1 = str1.replaceAll(regex, "");
            String temp2 = str2.replaceAll(regex, "");

            if (temp1.isEmpty() && temp2.isEmpty()) {
                res = regex;
                break;
            }
        }

        return res;
    }

    // 배열 사용
    public String gcdOfStrings_2(String str1, String str2) {
        String res = "";

        for(int i=str2.length(); i>0; i--) {
            String regex = str2.substring(0,i);
            String[] arr1 = str1.split(regex);
            String[] arr2 = str2.split(regex);

            if(arr1.length == 0 && arr2.length == 0) {
                res = regex;
                break;
            }
        }

        return res;
    }

}
