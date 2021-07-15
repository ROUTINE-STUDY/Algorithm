import java.util.HashMap;
import java.util.Map;

class Solution {
    public char findTheDifference(String s, String t) {
        char answer = ' ';
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)-1);
            if (map.get(c)==-1) {
                answer = c;
                break;
            }
        }

        return answer;
    }
}