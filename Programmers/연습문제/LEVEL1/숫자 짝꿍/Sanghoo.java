package programmers.숫자짝꿍;

import java.math.BigInteger;

public class Sanghoo {

    public static void main(String[] args) {
        solution("100", "100");
    }

    public static String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] xArr = new int[10];
        int[] yArr = new int[10];

        // 문자열 안 문자 갯수 카운팅 | "0012" -> [2, 1, 1, 0, 0, 0, 0, 0, 0, 0]
        for (char ch : X.toCharArray()) {
            xArr[ch - '0']++;
        }
        for (char ch : Y.toCharArray()) {
            yArr[ch - '0']++;
        }

        // 내림차순을 위해 역순으로 순회
        for (int i = xArr.length - 1; i >= 0; i--) {
            while (xArr[i] > 0 && yArr[i] > 0) { // 중복된 갯수만큼 문자열 이어붙이기
                answer.append(i);

                if (xArr[i] > 0) xArr[i]--; // -1 누적
                if (yArr[i] > 0) yArr[i]--; // -1 누적
            }
        }

        // 자릿수가 2자리 이상인데, 맨 앞이 0이라면 "00~~"
        if (answer.length() > 1 && answer.indexOf("0") == 0) {
            answer = new StringBuilder("0");
        }

        return answer.length() == 0 ? "-1" : answer.toString();
    }
}
