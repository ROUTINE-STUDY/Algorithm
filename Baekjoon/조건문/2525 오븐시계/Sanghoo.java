package BaekJoon.오븐시계_2525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] time = br.readLine().split(" ");
            int cookingTime = Integer.parseInt(br.readLine());
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);

            minute += cookingTime;

            if (minute >= 60) {
                hour += (minute / 60);
                minute %= 60;

                if (hour >= 24) {
                    hour -= 24;
                }
            }

//            hour = (hour + (minute + cookingTime) / 60) % 24 ;
//            minute = (minute + cookingTime) % 60;

            System.out.printf("%d %d", hour, minute);
        }

    }

}
