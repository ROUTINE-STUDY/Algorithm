import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        int numOfProplems = 11;
        int[] penalties = new int[numOfProplems];
        int wrongCount = 0;
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0;  i < numOfProplems; i++) {
            String[] line = bfr.readLine().split(" ");
            penalties[i] = Integer.parseInt(line[0]);
            wrongCount += Integer.parseInt(line[1]);
        }
        Arrays.sort(penalties);

        int answer = 0;
        int sum = 0;
        for (int i = 0; i < numOfProplems; i++) {
            sum += penalties[i];
            answer += sum;
        }

        System.out.println(answer + wrongCount * 20);
    }
}