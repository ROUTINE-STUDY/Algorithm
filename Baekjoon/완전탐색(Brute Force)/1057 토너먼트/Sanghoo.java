package BaekJoon.토너먼트_1057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sanghoo {

    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int kimNumber = Integer.parseInt(st.nextToken());
            int limNumber = Integer.parseInt(st.nextToken());
            int round = 1;

            while (Math.abs(kimNumber - limNumber) >= 1) {
                if (Math.abs(kimNumber - limNumber) == 1 && (kimNumber + limNumber) % 4 == 3) {
                    break;
                }
                round++;
                kimNumber = (kimNumber % 2 == 0) ? kimNumber / 2 : kimNumber / 2 + 1;
                limNumber = (limNumber % 2 == 0) ? limNumber / 2 : limNumber / 2 + 1;
            }

            System.out.println(round);
        }
    }

}
