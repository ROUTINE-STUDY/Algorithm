package programmers.대충만든자판;

import java.util.HashMap;
import java.util.Map;

public class Sanghoo {
    public static void main(String[] args) {
        String[] keyMap = {"BC"};
        String[] targets = {"AC", "BC"};

        solution(keyMap, targets);
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> minKeyMap = new HashMap<>();

        // keymap을 역순으로 돌아, Map에 각 키(Key)를 최소한으로 나타낼 수 있는 개수(Value)를 저장해두고 사용한다.
        for (String key : keymap) {
            char[] chars = key.toCharArray();

            for (int j = chars.length - 1; j >= 0; j--) {
                int value = minKeyMap.get(chars[j]) == null ? Integer.MAX_VALUE : minKeyMap.get(chars[j]);
                minKeyMap.put(chars[j], Math.min(value, j + 1));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            for (char ch : targets[i].toCharArray()) {
                Integer getVal = minKeyMap.get(ch);

                // target을 만들 수 없을 경우 -1을 저장하고 break
                if (getVal == null) {
                    count = -1;
                    break;
                }
                count += getVal;
            }
            answer[i] = count;
        }

        return answer;
    }

}
