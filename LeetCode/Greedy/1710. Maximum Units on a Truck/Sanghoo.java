package Greedy.Maximum_Units_on_a_Truck;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 */
public class Sanghoo {

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;

        // 무게 기준으로 배열 내림차순 정렬(지난번 인규님의 코드리뷰에서 배운 내용)
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] > o2[1]) {
                    return -1;
                } else if(o1[1] < o2[1]) {
                    return 1;
                }
                return 0;
            }
        });

        // trunk 상자 만큼 담기
        // trunkSize > 상자의 수 라면 상자(box[0])를 다 넣으면 되고
        // trunkSize < 상자의 수 라면 남은 자리(trunkSize)만큼 채워주면 된다.
        for(int[] box : boxTypes) {

            if(box[0] <= truckSize) {
                res += (box[0] * box[1]);
                truckSize -= box[0];
            } else {
                res += (truckSize * box[1]);
                truckSize = 0;
            }

            if(truckSize == 0) return res;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{5,10}, {2,5}, {4,7}, {3,9}};
        int truckSize = 10;
        System.out.println(maximumUnits(boxTypes, truckSize));
    }
}
