package programmers.둘만의암호;

public class Sanghoo {
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        solution(s, skip, index);
    }

    public static String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int idx = index;
            while (idx > 0) {
                ch = (++ch > 'z') ? 'a' : ch;

                if (!skip.contains((String.valueOf(ch)))) {
                    idx--;
                }
            }
            sb.append(ch);
        }

        return sb.toString();
    }
}
