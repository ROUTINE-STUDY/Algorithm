import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int lenOfLAnt = Integer.parseInt(st.nextToken());
        int lenOfRAnt = Integer.parseInt(st.nextToken());
        char[] answer = new char[lenOfLAnt+lenOfRAnt];
        String leftAnt = new String(new StringBuilder(br.readLine()).reverse());
        String rightAnt = br.readLine();
        int time = Integer.parseInt(br.readLine());

        if (time >= lenOfLAnt+lenOfRAnt-1) {
            StringBuilder sb = new StringBuilder(rightAnt);
            System.out.println(sb.append(leftAnt));
            return;
        }

        int idxOfChangePivot = lenOfLAnt - time;
        int idxOfLeftAnt = 0;
        int idxOfRightAnt = 0;

        int index = 0;
        if (idxOfChangePivot < 0) {
            while (idxOfChangePivot++ < 0) {
                answer[index++] = rightAnt.charAt(idxOfRightAnt++);
            }
        }
        for (int i = index; i < answer.length; i++) {
            if (i >= idxOfChangePivot) {
                if (idxOfRightAnt == rightAnt.length()) {
                    for (int j = i; j < answer.length; j++) {
                        answer[j] = leftAnt.charAt(idxOfLeftAnt++);
                    }
                    break;
                }
                answer[i++] = rightAnt.charAt(idxOfRightAnt++);

                if (idxOfLeftAnt == leftAnt.length()) {
                    for (int j = i; j < answer.length; j++) {
                        answer[j] = rightAnt.charAt(idxOfRightAnt++);
                    }
                    break;
                }
                answer[i] = leftAnt.charAt(idxOfLeftAnt++);
            } else {
                answer[i] = leftAnt.charAt(idxOfLeftAnt++);
            }
        }

        for (char c : answer) {
            System.out.print(c);
        }
    }
}