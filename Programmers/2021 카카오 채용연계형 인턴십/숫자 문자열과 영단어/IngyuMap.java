import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<String, String> map = new HashMap<>();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");

        for (String key : map.keySet()) {
            if (s.contains(key))
                s = s.replaceAll(key, map.get(key));
        }

        return Integer.parseInt(s);
    }
}