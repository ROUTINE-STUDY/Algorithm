package Programmers.최소직사각형;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/86491
 */
public class Sanghoo {

    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for(int[] card : sizes) {
            // 가로/세로 길이 중 세로가 더 크면 명함을 회전시킴(기준 바꿔도 상관없음)
            if(card[0] < card[1]) {
                int temp = card[0];
                card[0] = card[1];
                card[1] = temp;
            }

            // 가로, 세로 최대값 구하기
            if(maxWidth < card[0]) maxWidth = card[0];
            if(maxHeight < card[1]) maxHeight = card[1];
        }

        // 최대 가로 * 세로 = 명함지갑 크기
        return maxWidth * maxHeight;
    }

}
