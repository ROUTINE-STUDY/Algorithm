package Array.Find_Common_Characters;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-common-characters/
 */
public class Sanghoo {

    // 첫 문자열을 기준 삼아 각 문자가 모두 포함이 되어있으면 res에 추가 및 해당 문자 삭제하는 방식으로 접근
    public static List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<String>();

        // 삭제를 쉽게 하기 위해 StringBuilder 사용
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for(String word : words) {
            list.add(new StringBuilder(word));
        }

        StringBuilder standard = list.get(0);   // 기준이 되는 첫 번째 문자열

        for(int i=0; i<standard.length(); i++) {
            char ch = standard.charAt(i);
            int index = 0;

            // 각 배열을 돌면서 하나라도 해당 문자(ch)가 없으면 break
            for(int j=1; j<list.size(); j++) {
                index = list.get(j).indexOf(String.valueOf(ch));
                if(index == -1) {
                    break;
                }
            }

            // 해당 문자(ch)가 모두 포함 되었다면
            if(index != -1) {
                // 각 문자열에서 해당 문자의 위치를 찾아 삭제 및 res 추가
                for(int k=1; k<list.size(); k++) {
                    int deleteIndex = list.get(k).indexOf(String.valueOf(ch));
                    list.get(k).deleteCharAt(deleteIndex);
                }
                res.add(String.valueOf(ch));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] words = {"dbaabcba","cabcdbab","cdbcbdad","abadbacc","bdddddaa","daddabab","baaaddaa","dccdaabd"};
        System.out.println(commonChars(words));
    }
}