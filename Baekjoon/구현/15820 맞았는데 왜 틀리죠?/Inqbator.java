import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Inqbator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(it -> Integer.parseInt(it)).toArray();

        for (int i = 0; i < input[0]; i++) {
            int[] answerAndTestCase = Arrays.stream(br.readLine().split(" ")).mapToInt(it -> Integer.parseInt(it)).toArray();
            if (answerAndTestCase[0] != answerAndTestCase[1]) {
                System.out.println("Wrong Answer");
                return;
            }
        }

        for (int i = 0; i < input[1]; i++) {
            int[] answerAndTestCase = Arrays.stream(br.readLine().split(" ")).mapToInt(it -> Integer.parseInt(it)).toArray();
            if (answerAndTestCase[0] != answerAndTestCase[1]) {
                System.out.println("Why Wrong!!!");
                return;
            }
        }

        System.out.println("Accepted");
    }
}
