import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] directionOfRow = {-1,0,1,0};
    static int[] directionOfColumn = {0,1,0,-1};
    static boolean[][] isVisited;
    static int maxSum = Integer.MIN_VALUE;
    static int sizeOfRow;
    static int sizeOfColumn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sizeOfRow = Integer.parseInt(st.nextToken());
        sizeOfColumn = Integer.parseInt(st.nextToken());
        map = new int[sizeOfRow][sizeOfColumn];

        for (int row = 0; row < sizeOfRow; row++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int column = 0; column < sizeOfColumn; column++) {
                map[row][column] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited = new boolean[sizeOfRow][sizeOfColumn];
        for (int row = 0; row < sizeOfRow; row++) {
            for (int column = 0; column < sizeOfColumn; column++) {
                isVisited[row][column] = true;
                maxSum = Math.max(backtracking(row, column, map[row][column],1), maxSum);
                isVisited[row][column] = false;
                maxSum = Math.max(getFuckShapeSum(row, column, sizeOfRow, sizeOfColumn), maxSum);
            }
        }
        System.out.println(maxSum);

    }

    private static int backtracking(int positionOfRow, int positionOfColumn, int sum, int depth) {
        if (depth == 4) {
            return sum;
        }

        for (int idxOfDirection = 0; idxOfDirection < directionOfRow.length; idxOfDirection++) {
            int nextRowPosition = positionOfRow+directionOfRow[idxOfDirection];
            int nextColumnPosition = positionOfColumn+directionOfColumn[idxOfDirection];

            if (!checkIsInMap(nextRowPosition, nextColumnPosition, sizeOfRow, sizeOfColumn) || isVisited[nextRowPosition][nextColumnPosition]) {
                continue;
            }
            isVisited[nextRowPosition][nextColumnPosition] = true;
            maxSum = Math.max(backtracking(nextRowPosition, nextColumnPosition, sum+map[nextRowPosition][nextColumnPosition],depth+1),maxSum);
            isVisited[nextRowPosition][nextColumnPosition] = false;
        }

        return maxSum;
    }

    private static boolean checkIsInMap(int positionOfRow, int positionOfColumn, int sizeOfRow, int sizeOfColumn) {
        if ((0 <= positionOfRow && positionOfRow < sizeOfRow) && (0 <= positionOfColumn && positionOfColumn < sizeOfColumn)) {
            return true;
        }
        return false;
    }

    private static int getFuckShapeSum(int positionOfRow, int positionOfColumn, int sizeOfRow, int sizeOfColumn) {
        // 4방향을 먼저 다 더하고 차례대로 빼고 해보자
        int fiveBlockSum = map[positionOfRow][positionOfColumn];

        for (int idxOfDirection = 0; idxOfDirection < directionOfRow.length; idxOfDirection++) {
            int nextRowPosition = positionOfRow + directionOfRow[idxOfDirection];
            int nextColumnPosition = positionOfColumn + directionOfColumn[idxOfDirection];
            if (checkIsInMap(nextRowPosition, nextColumnPosition, sizeOfRow, sizeOfColumn)) {
                fiveBlockSum += map[nextRowPosition][nextColumnPosition];
            }
        }

        int answer = 0;
        for (int idxOfDirection = 0; idxOfDirection < directionOfRow.length; idxOfDirection++) {
            int currentSum = fiveBlockSum;
            int nextRowPosition = positionOfRow + directionOfRow[idxOfDirection];
            int nextColumnPosition = positionOfColumn + directionOfColumn[idxOfDirection];
            if (checkIsInMap(nextRowPosition, nextColumnPosition, sizeOfRow, sizeOfColumn)) {
                currentSum -= map[nextRowPosition][nextColumnPosition];
            }
            answer = Math.max(currentSum,answer);
        }

        return answer;
    }
}