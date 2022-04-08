package BaekJoon.스위치켜고끄기_1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int switchCount = Integer.parseInt(br.readLine());
            String[] switchArr = br.readLine().split(" ");
            int studentCount = Integer.parseInt(br.readLine());

            for (int i = 0; i < studentCount; i++) {
                String[] inputInfo = br.readLine().split(" ");
                int index = Integer.parseInt(inputInfo[1]);

                if ("1".equals(inputInfo[0])) { // 남학생
                    for (int j = index - 1; j < switchCount; j += index) {
                        switchArr[j] = ("1".equals(switchArr[j])) ? "0" : "1";
                    }
                } else { // 여학생
                    int standard = --index;
                    int left = standard;
                    int right = standard;

                    while (left >= 0 && right < switchCount) {
                        if (switchArr[left].equals(switchArr[right])) {
                            switchArr[right] = switchArr[left] = ("1".equals(switchArr[left])) ? "0" : "1";
//                            switchArr[right] = ("1".equals(switchArr[right])) ? "0" : "1";
//                            switchArr[left] = ("1".equals(switchArr[left])) ? "0" : "1";
                        } else {
                            break;
                        }
                        left--;
                        right++;
                    }
                }
            }

            // 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < switchArr.length; i++) {
                if (i > 1 && i % 20 == 0) sb.append("\n");
                sb.append(switchArr[i]).append(" ");
            }

            System.out.println(sb);
        }

    }

}
