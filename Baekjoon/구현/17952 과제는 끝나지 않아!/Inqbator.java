import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class Inqbator {
    static class Work {
        private int score;
        private int minute;

        public Work(int score, int minute) {
            this.score = score;
            this.minute = minute;
        }

        public int getScore() {
            return score;
        }

        public int getMinute() {
            return minute;
        }

        public void execute() {
            this.minute--;
        }
    }

    public static void main(String[] args) throws IOException {
        int result = 0;
        try(final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            Stack<Work> stack = new Stack<>();

            for (int i = 0; i < N; i++) {
                int[] workInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(it -> Integer.parseInt(it)).toArray();
                Work work = null;

                if(workInfo.length > 1) {
                    if (workInfo[2] == 1) {
                        result += workInfo[1];
                        continue;
                    }
                    work = new Work(workInfo[1], workInfo[2] - 1);
                    stack.push(work);
                } else {
                    if(!stack.isEmpty()) {
                        work = stack.peek();
                        work.execute();

                        if (work.getMinute() == 0) {
                            result += work.getScore();
                            stack.pop();
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
}