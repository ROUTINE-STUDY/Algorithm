class Solution {
    public int[] diStringMatch(String s) {
        int[] answer = new int[s.length()+1];
        int min = 0;
        int max = answer.length - 1;

        for (int i = 0; i < s.length(); i++) {
            answer[i] = s.charAt(i) == 'I' ? min++ : max--;
        }

        answer[answer.length-1] = min;
        return answer;
    }
}