package String.Keyboard_Row;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/keyboard-row/
 */
public class Sanghoo {

    // 정규표현식을 활용하여 풀이하였습니다.
    public String[] findWords(String[] words) {
        String[] patterns = new String[]{"^[qwertyuiop]*$", "^[asdfghjkl]*$", "^[zxcvbnm]*$"};
        List<String> list = new ArrayList<>(Arrays.asList(words));

        for(int i=list.size()-1; i>=0; i--) {
            String word = list.get(i).toLowerCase();
            boolean isMatch = false;

            for(String pattern : patterns) {
                if(Pattern.matches(pattern, word)) {
                    isMatch = true;
                    break;
                }
            }
            if(!isMatch) list.remove(i);
        }

        return list.size() > 0 ? list.toArray(new String[list.size()]) : new String[]{};
    }


}
