import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(it -> Integer.parseInt(it)).toArray();
        int N = inputs[0];
        int M = inputs[1];
        boolean[] isVisited = new boolean[N+1];

        inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(it -> Integer.parseInt(it)).toArray();
        for (int i = 0; i < inputs.length; i++) {
            for (int currentNumber = inputs[i]; currentNumber <= N; currentNumber+=inputs[i]) {
                if (!isVisited[currentNumber]) {
                    answer += currentNumber;
                    isVisited[currentNumber] = true;
                }
            }
        }

        System.out.println(answer);
    }
}
