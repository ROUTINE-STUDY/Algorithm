package BaekJoon._2007_1924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().split(" ");
            int month = Integer.parseInt(input[0]);
            int day = Integer.parseInt(input[1]);

            DayOfWeek dayOfWeek = LocalDate.of(2007, month, day).getDayOfWeek();

            System.out.printf("%.3s", dayOfWeek.toString());
        }

    }

}
