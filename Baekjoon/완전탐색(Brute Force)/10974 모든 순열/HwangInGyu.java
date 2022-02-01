import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        boolean[] isVisited = new boolean[N];

        int idxOfCurrentNode = 0;
        int[] answer = new int[N];
        recursion(idxOfCurrentNode, isVisited, answer);
        System.out.println(sb);
    }

    private static void recursion(int idxOfCurrentNode, boolean[] isVisited, int[] answer) {
        if (idxOfCurrentNode == isVisited.length) {
            for (int i : answer) {
                sb.append(i);
                sb.append(" ");
            }
            sb.append("\n");
        }

        for (int i = 0; i < answer.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            answer[idxOfCurrentNode] = i+1;
            recursion(idxOfCurrentNode+1, isVisited, answer);
            isVisited[i] = false;
            answer[idxOfCurrentNode] = 0;
        }
    }
}