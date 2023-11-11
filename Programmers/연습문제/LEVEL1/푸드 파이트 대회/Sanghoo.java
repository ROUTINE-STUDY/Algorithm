package Programmers.푸드파이터대회;

public class Sanghoo {

    public static void main(String[] args) {
        solution(new int[]{1, 7, 1, 2});
    }

    public static String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(i);
            }
        }

        answer = sb.toString() + "0" + sb.reverse();
        return answer;
    }

}
