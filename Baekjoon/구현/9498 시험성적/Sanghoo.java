package BaekJoon.시험성적_9498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo {

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int score = Integer.parseInt(br.readLine());

            String grade = getGrade(score);
            System.out.println(grade);
        }
    }

    private static String getGrade(int score) {
        String result;

        if(score >= 90) {
            result = "A";
        } else if(score >= 80) {
            result = "B";
        } else if(score >= 70) {
            result = "C";
        } else if (score >= 60) {
            result = "D";
        } else {
            result = "F";
        }

        return result;
    }

}
