class Solution {
    public int numWaterBottles(int numB, int numE) {

        int drinking = 0; // 마신횟 수
        int nam = 0; // 빈병

        while(numB > 0 && numE > nam){
            if(numB > 0){
                drinking+=numB;
                nam+=numB;
                numB=0;
            }

            if(nam/numE > 0){
                numB+=nam/numE;
                nam-=numB * numE;
            }
        }

        return drinking;
    }
}
/*
    numB 는 채워져 있는 코크
    numE 는 바꿔주는 기준
    nam 빈 병!
    drinking 은 마신 횟수 return 정답 값.
    1. 채워져 있는 코크가 0개 이상이면 일단 마신다.
    2. 마신만큼, drinking이 올라가고, 빈병도 올라간다.
    3. 채워져 있는 코크는 다 마셨으므로 , 0으로 돌아간다.
    4. while문을 통해 채워져 있는 코크가 없고 , 빈병이 기준보다 낮으면 끝난다 ..
    5. 빈 병이 기준에 맞을 경우 , 1개의 채워진 코크로 바꿔준다. (나머지를 기준으로 나눔)
    6. 기준만큼, 풀로 채워주고 , 그 만큼 빈병을 없앤다.
*/