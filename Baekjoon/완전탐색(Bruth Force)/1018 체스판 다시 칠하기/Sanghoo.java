import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sanghoo {

    static char[][] board;
    final static int boardWidth = 8;
    final static int boardHeight = 8;
    final static int boardSize = boardWidth * boardHeight;

    public static void main(String[] args) throws IOException {
        int result = 2500;

        try(final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int inputN = Integer.parseInt(st.nextToken());
            int inputM = Integer.parseInt(st.nextToken());

            board = new char[inputN][];
            for(int i=0; i<inputN; i++) {
                board[i] = br.readLine().toCharArray();
            }

            for(int i=0; i<inputN-7; i++) {
                for(int j=0; j<inputM-7; j++) {
                    result = Math.min(result, getPaintingCount(i , j));
                }
            }

            System.out.println(result);
        }

    }

    private static int getPaintingCount(int row, int col) {
        int paintingCount = 0;

        for(int i=row; i<row+boardWidth; i++) {
            char targetColor = (i%2 == 0) ? 'B' : 'W';
            for(int j=col; j<col+boardHeight; j++) {
                char curBoardColor = board[i][j];
                paintingCount = (targetColor == curBoardColor) ? paintingCount : ++paintingCount;
                targetColor = (targetColor == 'B') ? 'W' : 'B';
            }
        }

        return Math.min(paintingCount, boardSize - paintingCount);
    }

}
