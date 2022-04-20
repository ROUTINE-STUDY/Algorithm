package BaekJoon.한동이는공부가하기싫어_3182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int result = 0, maxVisit = 0;
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 1; i < arr.length; i++) {
                HashSet<Integer> hs = new HashSet<>(n);
                hs.add(i);
                int visit = arr[i];

                for (int j = 1; j < arr.length; j++) {
                    if (!hs.add(visit)) {
                        break;
                    }
                    visit = arr[visit];
                }

                if (maxVisit < hs.size()) {
                    result = i;
                    maxVisit = hs.size();
                }
            }

            System.out.println(result);
        }
    }

}
