package BaekJoon.하얀칸_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sanghoo {

    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int boardSize = 8;
            String[] chessBoard = new String[boardSize];
            int result = 0;

            for (int i = 0; i < chessBoard.length; i++) {
                chessBoard[i] = br.readLine();
            }

            for (int i = 0; i < chessBoard.length; i++) {
                char[] row = chessBoard[i].toCharArray();
                int whitePoint = (i % 2 == 0) ? 0 : 1;

                for (int j = whitePoint; j < row.length; j += 2) {
                    if (row[j] == 'F') result++;
                }
            }

            System.out.print(result);
        }
    }

}
