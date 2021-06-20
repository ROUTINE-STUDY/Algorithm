import java.util.Arrays;

class Ingyu {
    public int lastStoneWeight(int[] stones) {
        //무게순으로 정렬.
        Arrays.sort(stones);
        //스톤이 1개밖에 없으면 바로 첫번째 돌 리턴.
        if (stones.length <= 1) {
            return stones[0];
        }

        int index = stones.length - 1;      //맨끝에 최대값을 가르키게 함.
        while (stones[1] != 1001) {
            if (stones[index] == 1001) {
                index--;
                continue;
            }
            int temp = stones[index];
            stones[index] = 1001;
            stones[index - 1] = temp - stones[index - 1];
            index--;
            Arrays.sort(stones);
        }

        return stones[0];
    }
}