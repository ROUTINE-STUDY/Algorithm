import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        // 왼쪽 개미의 크기
        int lenOfLAnt = Integer.parseInt(st.nextToken());
        // 오른쪽 개미의 크기
        int lenOfRAnt = Integer.parseInt(st.nextToken());
        // 모든 개미가 들어갈 공간
        char[] answer = new char[lenOfLAnt+lenOfRAnt];
        // 왼쪽 개미 문자열
        String leftAnt = new String(new StringBuilder(br.readLine()).reverse());
        // 오른쪽 개미 문자열
        String rightAnt = br.readLine();
        // 지나가는 시간
        int time = Integer.parseInt(br.readLine());

        // 전체 길이보다 시간이 많이 지났으면 오른쪽 개미가 전부 왼쪽으로 이동했음.
        // 따라서 오른쪽 개미 뒤에 왼쪽 개미를 붙여줌.
        if (time >= lenOfLAnt+lenOfRAnt-1) {
            StringBuilder sb = new StringBuilder(rightAnt);
            System.out.println(sb.append(leftAnt));
            return;
        }

        // 개미가 번갈아 바뀌기 시작하는 인덱스
        int idxOfChangePivot = lenOfLAnt - time;
        // 현재 넣어야할 왼쪽 개미
        int idxOfLeftAnt = 0;
        // 현재 넣어야할 오른쪽 개미
        int idxOfRightAnt = 0;

        // 전체 개미가 들어갈 공간에 인덱스
        int index = 0;
        // 바뀌는 기준이 0보다 작으면, 오른쪽 개미가 먼저 연속으로 나와야함.
        if (idxOfChangePivot < 0) {
            while (idxOfChangePivot++ < 0) {
                answer[index++] = rightAnt.charAt(idxOfRightAnt++);
            }
        }

        for (int i = index; i < answer.length; i++) {
            // 번갈아 가면서 개미를 넣어줌.
            if (i >= idxOfChangePivot) {
                // if) 오른쪽 개미 다 넣었으면 -> 남은 왼쪽 개미를 넣어주면 됨.
                if (idxOfRightAnt == rightAnt.length()) {
                    for (int j = i; j < answer.length; j++) {
                        answer[j] = leftAnt.charAt(idxOfLeftAnt++);
                    }
                    break;
                }
                // 오른쪽 개미 넣기
                answer[i++] = rightAnt.charAt(idxOfRightAnt++);

                // if) 왼쪽 개미 다 넣었으면 -> 남은 오른쪽 개미들 넣어주면 됨
                if (idxOfLeftAnt == leftAnt.length()) {
                    for (int j = i; j < answer.length; j++) {
                        answer[j] = rightAnt.charAt(idxOfRightAnt++);
                    }
                    break;
                }
                // 왼쪽 개미 넣기
                answer[i] = leftAnt.charAt(idxOfLeftAnt++);
            } else {
                // 번갈아 넣지 않고 왼쪽 개미 쭉 넣어줌.
                answer[i] = leftAnt.charAt(idxOfLeftAnt++);
            }
        }

        for (char c : answer) {
            System.out.print(c);
        }
    }
}