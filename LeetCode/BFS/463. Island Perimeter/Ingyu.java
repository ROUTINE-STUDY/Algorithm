class Solution {
    public int islandPerimeter(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) answer += 4;
                else {
                    int count = checkOutside(grid, i, j);
                    answer += count;
                }
            }
        }

        return answer;
    }

    private int checkOutside(int[][] grid, int i, int j) {
        int count = 0;
        // 왼
        if (0 <= j-1 && grid[i][j-1] == 1) count--;
        // 우
        if (j+1 < grid[i].length && grid[i][j+1] == 1) count --;
        // 위
        if (0 <= i-1 && grid[i-1][j] == 1) count--;
        // 아래
        if (i+1 < grid.length && grid[i+1][j] == 1) count--;

        return count;
    }
}