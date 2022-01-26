import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sanghoo {

    static char[][] board;
    final static int boardRowSize = 8;
    final static int boardColSize = 8;
    final static int boardSize = boardRowSize * boardColSize;

    public static void main(String[] args) throws IOException {
        int result = 2500;

        try(final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int inputN = Integer.parseInt(st.nextToken());
            int inputM = Integer.parseInt(st.nextToken());

            // 입력 받기
            board = new char[inputN][];
            for(int i=0; i<inputN; i++) {
                board[i] = br.readLine().toCharArray();
            }

            /*
            row는 행의 수(입력받은 개수)를 의미하고, col은 열의 수(각 입력의 인덱스)를 의미
            boardRowSize 및 boardColSize - 1을 한 이유는 모든 경우의 수를 그려보던 중 규칙 발견
            (i, j) = (0,0), (0,1) ...  이런식으로 자를 수 있는 보드판의 지점을 얻을 수 있음
            */
            for(int i = 0; i<=inputN-boardRowSize; i++) {
                for(int j = 0; j<=inputM-boardColSize; j++) {
                    // 자를 수 있는 보드판 경우의 수 모두 탐색
                    result = Math.min(result, getPaintingCount(i , j));
                }
            }

            System.out.println(result);
        }

    }

    // 해당 보드판에서 적게 칠하는 개수를 반환
    private static int getPaintingCount(int row, int col) {
        int paintingCount = 0;

        for(int i = row; i<row+boardRowSize; i++) {
            // 처음에는 시작점이 검정, 흰색인 케이스들까지 고려하여 모두 구하려고 했으나, 한 케이스만 구하면 그 반대는 역으로 구할 수 있음을 확인(그림 및 노가다..)
            // 행별로 시작하는 color 지정(짝수는 검정, 홀수는 흰색으로 지정)
            char targetColor = (i%2 == 0) ? 'B' : 'W';
            for(int j = col; j<col+boardColSize; j++) { // 열의 시작점에서 원하는 보드 크기만큼 확인해야함
                char curBoardColor = board[i][j];
                if(targetColor != curBoardColor) ++paintingCount;
                targetColor = (targetColor == 'B') ? 'W' : 'B'; // 안쪽 반복문에서 계속 targetColor를 반전시키며 진행
            }
        }

        // 위 for문으로 검정색으로 시작할때의 개수를 구했고, 보드의 크기를 활용하여 반대의 케이스 수 구하여 더 작은 값 return
        return Math.min(paintingCount, boardSize - paintingCount);
    }

}
