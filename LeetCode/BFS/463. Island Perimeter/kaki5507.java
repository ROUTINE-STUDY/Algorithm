class Solution {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[i].length; j++) {
				if(grid[i][j] == 1) {
					sum+=4;
					
					// 위,아래 사각형이 있을경우 추가
					// 맨 윗줄이 아니고, 위치가 같을 경우
					// 2개는 각각 8인데 위에있을 경우 -1 하면됨.
					if(i > 0 && grid[i-1][j] == 1) {
						sum+=-1;
					}
					// else if로 만들어서는 안됨. 아래에도 있음.
					// i+1의 값이 길이보다는 이하여야 함. 넘어가면 index 초과 
					if(i+1 < grid.length && grid[i+1][j] == 1) {
						sum+=-1;
					}
					
					// 옆에 있는 경우 옆도 동일 하다.
					// 옆 왼쪽
					if(j > 0 && grid[i][j-1] == 1) {
						sum+=-1;
					}
					
					// 옆 오른쪽
					if(j+1 < grid[i].length && grid[i][j+1] == 1) {
						sum+=-1;
					}
				}
			}
		}
        
        return sum;
    }
}