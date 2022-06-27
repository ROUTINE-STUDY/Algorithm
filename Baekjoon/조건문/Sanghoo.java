package BaekJoon.알람시계_2884;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] time = br.readLine().split(" ");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);

//            if (minute < 45) {
//                hour = (hour == 0) ? 23 : hour - 1;
//                minute = 60 - (45 - minute);
//            } else {
//                minute -= 45;
//            }

            minute = minute - 45;
            if (minute < 0) {
                hour--;
                minute = 60 + minute;
                if (hour < 0)
                    hour = 23;
            }

            System.out.printf("%d %d", hour, minute);
        }

    }
}
