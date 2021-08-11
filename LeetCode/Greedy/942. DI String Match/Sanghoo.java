package Greedy.DI_String_Match;

/**
 * https://leetcode.com/problems/di-string-match/
 */
public class Sanghoo {

    public int[] diStringMatch(String s) {
        int[] res = new int[s.length()+1];
        int head = 0;
        int tail = s.length();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            res[i] = ch=='I' ? head++ : tail--;
        }

        // tail 값을 넣어도 상관 X, 안들어간 빈 값을 똑같이 가리킴
        res[s.length()] = head;
//        res[s.length()] = tail;

        return res;
    }

}
