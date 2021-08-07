class Solution {
    public int countGoodRectangles(int[][] rect) {
        int maxleg = 0;
		int count = 0;
		for(int i=0; i<rect.length; i++) {
			int leg = Math.min(rect[i][0], rect[i][1]);
			
			// 정사각형 최대 크기
			if(leg > maxleg) {
				maxleg = leg;
				count = 1;
			}else if(leg == maxleg) {
				count++;
			}
		}
        return count;
    }
}