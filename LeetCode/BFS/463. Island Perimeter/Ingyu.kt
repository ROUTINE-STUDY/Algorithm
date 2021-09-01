class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var sum = 0
        fun checkOutline(grid:Array<IntArray>, i:Int, j:Int):Int {
            var neighbor = 0
            // left
            if (0 <= j-1 && grid[i][j-1] == 1) neighbor++
            // right
            if (j+1 < grid[i].size && grid[i][j+1] == 1) neighbor++
            // top
            if (0 <= i-1 && grid[i-1][j] == 1) neighbor++
            // bottom
            if (i+1 <grid.size && grid[i+1][j] == 1) neighbor++

            return neighbor
        }

        for (i in 0..grid.size-1) {
            for (j in 0..grid[i].size-1) {
                if (grid[i][j] == 1) {
                    sum += 4
                    sum -= checkOutline(grid, i,j)
                }
            }
        }

        return sum
    }
}