package Stack.Maximum_Nesting_Depth_of_the_Parentheses;

/**
 * https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 */
public class Sanghoo {

    // 연속된 '('를 카운팅하고 최대 count를 return 합니다.
    public int maxDepth(String s) {
        int count = 0;
        int res = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                if(res < ++count) res = count;
            } else if(s.charAt(i) == ')') {
                --count;
            }
        }

        return res;
    }

}
