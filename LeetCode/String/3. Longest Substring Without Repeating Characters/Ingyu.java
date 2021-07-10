import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        int length = 0;

        for (char c : s.toCharArray()) {
            queue.offer(c);

            if (!set.add(c)) {
                //set은 중복되는 게 없으므로,
                //set의 사이즈가 길이가 됨.

//                if (set.size() > length) length = set.size();
                length = Math.max(set.size(),length);

                //이미 들어간 문자가 나올 때까지 poll
                while (!queue.isEmpty()) {
                    char temp = queue.poll();
                    //새로 문자열을 만들어야하므로 set에서도 지움.
                    set.remove(temp);
                    //이미 들어간 문자가 나오면, 중복 되는 문자가 없으므로 break.
                    if (temp == c) break;
                }
                //queue에는 중복된 문자가 들어가있으므로,
                //set에도 넣어줌.
                set.add(c);
            } else {
                //같은 문자가 없으므로 queue의 크기가
                //최대 문자열의 크기임.
                length = Math.max(queue.size(), length);
            }
        }

        return length;
    }
}