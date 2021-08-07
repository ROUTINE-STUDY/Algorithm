class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int i=0; i<bills.length; i++){
            if(bills[i] == 5){ // 5가 나오면 지폐 개수 추가
                five++;
            }else if(bills[i] == 10){ // 10 나오면 지폐 개수 추가
                if(five < 1){return false;} //
                five--;ten++;
            }else if(bills[i] == 20){ // 20 나오면 5 지폐 3개 10 1개 5 1개로 가능
                if(ten >=1 && five >=1){
                    ten--; five--;
                    continue;
                }else if(five>=3){
                    five = five - 3;
                    continue;
                }else{return false;}
            }
        }
        return true;

    }
}