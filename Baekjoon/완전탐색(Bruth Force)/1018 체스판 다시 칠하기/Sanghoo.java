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

            board = new char[inputN][];
            for(int i=0; i<inputN; i++) {
                board[i] = br.readLine().toCharArray();
            }

            for(int i = 0; i<inputN-(boardRowSize-1); i++) {
                for(int j = 0; j<inputM-(boardColSize-1); j++) {
                    result = Math.min(result, getPaintingCount(i , j));
                }
            }

            System.out.println(result);
        }

    }

    private static int getPaintingCount(int row, int col) {
        int paintingCount = 0;

        for(int i = row; i<row+boardRowSize; i++) {
            char targetColor = (i%2 == 0) ? 'B' : 'W';
            for(int j = col; j<col+boardColSize; j++) {
                char curBoardColor = board[i][j];
                paintingCount = (targetColor == curBoardColor) ? paintingCount : ++paintingCount;
                targetColor = (targetColor == 'B') ? 'W' : 'B';
            }
        }

        return Math.min(paintingCount, boardSize - paintingCount);
    }

}
