import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //박스의 무게를 기준으로 내림차순으로 정렬합니다.
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) {
                    return 1;
                } else if (o1[1] > o2[1]) {
                    return -1;
                }
                return 0;
            }
        });

        //현재 트럭이 가지고 있는 박스 개수
        int currentWeight = 0;
        //현재 트럭의 들어있는 박스의 개수
        int currentBox = 0;

        //박스
        for (int[] box : boxTypes) {
            //box[0] : 박스 개수
            //box[1] : 박스의 무게

            //현재 박스의 개수가 트럭이 가질 수 있는 박스 개수와 같아지면 반복문을 빠져 나옵니다.
            if (currentBox == truckSize) {
                break;
            }
            //각 배열마다 들어갈 수 있는 박스의 개수에 최대값을 넣은 후
            //그 값이 트럭의 한계보다 크면, 들어갈 수 있는 개수만 넣어줍니다.
            //만약에 박스 개수의 최대값과 현재 박스 개수의 합이
            //트럭의 한계보다 작거나 같다면 최대값만큼 현재 박스 개수를 늘려주고,
            //무게*최대개수만큼 무게를 더해줍니다.
            if (currentBox + box[0] > truckSize) {
                currentWeight += box[1] * (truckSize - currentBox);
                currentBox += truckSize - currentBox;
            } else {
                currentWeight += box[1] * box[0];
                currentBox += box[0];
            }
        }

	//최대값을 리턴.
        return currentWeight;
    }
}