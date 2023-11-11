package programmers.햄버거만들기;

public class Sanghoo {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 2, 1, 2, 3, 1, 1, 2, 3, 1};
        solution(arr);
    }

    public static int solution(int[] ingredient) {
        final String MAKE_BURGER = "1231";
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for (int i : ingredient) {
            sb.append(i);

            if (i == 1 && sb.length() >= 4 && sb.subSequence(sb.length() - 4, sb.length()).equals(MAKE_BURGER)) {
                sb.delete(sb.length() - 4, sb.length());
                answer++;
            }
        }

        return answer;
    }

}
