package String.Longest_Common_Prefix;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class Sanghoo {

    public String longestCommonPrefix(String[] strs) {
        String res = "";

        // 문자열 길이가 작은 순으로 내림차순 정렬
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) return 1;
                if(o1.length() < o2.length()) return -1;
                return 0;
            }
        });

        StringBuilder standard = new StringBuilder(strs[0]);            // 기준이되는 첫 번째 문자열
        for(int i=standard.length()-1; i>=0; i--) {
            boolean isEquals = true;                                    // 일치하는지 확인하기 위한 flag 값

            for(int j=1; j<strs.length; j++) {
                String str = strs[j].substring(0, standard.length());   // 기준과 똑같은 인덱스로 잘라낸 문자열

                if(!str.equals(standard.toString())) {                  // 같은지 판단 후 하나라도 다르다면 flag false 후 break
                    isEquals = false;
                    break;
                }
            }

            if(isEquals) {                                              // 모두 같다면 return value 저장 후 break
                res = standard.toString();
                break;
            }
            standard = standard.deleteCharAt(i);                        // 기준 문자열 꼬리부터 하나씩 제거
        }

        return res;
    }

}
