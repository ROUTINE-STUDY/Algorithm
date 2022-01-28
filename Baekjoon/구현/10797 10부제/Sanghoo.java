package BaekJoon._10부제_10797;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sanghoo {
    static String day;

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            day = br.readLine();
            StringTokenizer carNumber = new StringTokenizer(br.readLine(), " ");
            int result;

            result = getViolateCarCount(carNumber);

            System.out.println(result);
        }

    }

    private static int getViolateCarCount(StringTokenizer carNumber) {
        int violateCount = 0;

        while(carNumber.hasMoreTokens()) {
            if(day.equals(carNumber.nextToken())) { violateCount++; }
        }

        return violateCount;
    }

}
