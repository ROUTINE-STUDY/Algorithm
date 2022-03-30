package BaekJoon.과제는끝나지않아_17952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sanghoo {

    public static void main(String[] args) throws IOException {
        int result = 0;

        try(final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            Stack<Work> stack = new Stack<>();

            for (int i = 0; i < N; i++) {
                String[] workInfo = br.readLine().split(" ");
                Work work = null;

                if(workInfo.length > 1) {
                    work = new Work(Integer.parseInt(workInfo[1]), Integer.parseInt(workInfo[2]) - 1);
                    stack.push(work);
                } else {
                    if(!stack.isEmpty()) {
                        work = stack.peek();
                        work.execute();
                    }
                }

                if(!stack.isEmpty() && work.getMinute() == 0) {
                    result += work.getScore();
                    stack.pop();
                }
            }

            System.out.println(result);
        }
    }

}

class Work {
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