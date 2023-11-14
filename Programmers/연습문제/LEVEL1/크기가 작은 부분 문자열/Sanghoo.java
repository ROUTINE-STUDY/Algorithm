package programmers.크기가작은부분문자열;

public class Sanghoo {

    public static void main(String[] args) {
        String t = "3141592";
        String p = "271";

        solution(t, p);
    }

    public static int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i <= t.length() - p.length(); i++) {
            String subStr = t.substring(i, i + p.length());
            if (Long.parseLong(subStr) <= Long.parseLong((p))) {
                answer++;
            }
        }
        return answer;
    }

}
