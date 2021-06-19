class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int answer = 0;            //최대 넓이를 가진 도형의 갯수.
        int max = 0;            //최대 넓이 도형 길이.
        for (int i = 0; i < rectangles.length; i++) {
            //변 중에서 제일 짧은 변의 길이를 구함.
            int temp = Math.min(rectangles[i][0],rectangles[i][1]);

            if (temp > max) {        //변의 길이가 최댓값보다 크면
                max = temp;            //최댓값은 새로 구한 변의 길이.
                answer = 1;            //최댓값의 기준이 바꼈으므로 갯수는 1부터 다시 시작.
            } else if (temp == max) {    //변의 길이가 최댓값과 같으면
                answer++;                //최대 넓이를 가진 도형의 갯수가 1 증가.
            }
        }

        return answer;
    }
}