class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int size = stones.length;
        while(size > 1) {
            int cha = stones[stones.length-1] - stones[stones.length-2];

            if(cha > 0) {
                stones[stones.length-1] = cha;
                stones[stones.length-2] = 0;
            }else if(cha == 0) {
                stones[stones.length-1] = 0;
                stones[stones.length-2] = 0;
            }
            Arrays.sort(stones);
            size--;
        }
        return stones[stones.length-1];
    }

    /*
      문제 분석
      1. 가장 큰 값 두개를 비교해서 차이값을 다시 넣는다.
      2. 그 다음 큰 수를 비교해서 차이값을 다시 넣는다.
      3. 하나가 남으면 그게 last stone의 값 !

      풀이
      1. 배열을 작은 순서대로 정렬
      2. size를 1보다 크게 선언해야 함. (사이즈가 2개가 있어야 하나의 값이 나오기 때문 사이즈 0 이면 안돔)
      3. 마지막-1에 cha를 넣어줘도되고 마지막-2 cha를 넣어줘도 됨.
    */

}